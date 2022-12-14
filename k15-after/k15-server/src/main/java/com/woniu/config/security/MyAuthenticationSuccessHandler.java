package com.woniu.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.util.JwtTokenUtil;
import com.woniu.util.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 自定义登录成功处理器
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = request.getParameter("username");
        // 生成token返回给前端，同时我们还可以把该用户的权限标识符查询出来存到redis
        String token = JwtTokenUtil.createToken(username);

        ResponseResult<String> success = new ResponseResult<String>(token,"登陆成功",200);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(success));
    }
}
