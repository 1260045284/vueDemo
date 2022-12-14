package com.woniu.config.security;

import com.woniu.exception.MyTokenIsInvalidException;
import com.woniu.exception.MyTokenIsNullException;
import com.woniu.service.IUserService;
import com.woniu.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private IUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1.首先拿到token字符串，当用户发送非认证请求时，规定这个token字符串是放在请求头过来的
        String token = request.getHeader("token");

        // 2. 校验这个token是否为null
        if(StringUtils.isEmpty(token)) {
            String uri = request.getRequestURI().toString();
            if(uri.equals("/login") || uri.equals("/login.html") || uri.startsWith("/js/") || uri.startsWith("/css/") || uri.equals("/favicon.ico")) {
                // 如果请求地址是 /login   /login.html  js css，则直接放行
                filterChain.doFilter(request, response);
                return;
            } else {
                authenticationFailureHandler.onAuthenticationFailure(request, response, new MyTokenIsNullException("Token is Null"));
                return;
            }
        }

        //token 不为空，校验合法
        if(JwtTokenUtil.checkToken(token)) { // 合法
            String username = JwtTokenUtil.getUsername(token);
            // 3. 根据用户名查询数据库，获取用户的权限集合
            List<String> perms = userService.selectPermscodeByUserame(username);

            List<GrantedAuthority> list = new ArrayList<>();
            perms.forEach(perm->{
                GrantedAuthority authority = new SimpleGrantedAuthority(perm);
                list.add(authority);
            });

            // 4.创建验证的用户AuthenticationToken对象
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, "", list);

            // 5. 装入security 容器中
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            // 6.继续放行
            filterChain.doFilter(request, response);
        } else {    // 不合法
            authenticationFailureHandler.onAuthenticationFailure(request, response, new MyTokenIsInvalidException("Token is Invalid!"));
            return;
        }

    }
}
