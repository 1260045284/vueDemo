package com.woniu.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        // security在内存中定义一个默认的用户名和密码
//        auth.inMemoryAuthentication()
//                .withUser("woniu")
//                .password(passwordEncoder.encode("123456")).roles();

        // 最终认证做法，是当用户输入用户名和密码的时候，表单提交的url 是：/login，然后security根据我们提交的用户名和密码
        // 去数据库查询是否有   没有就登陆失败，否则就登陆成功
        // 将来做认证的时候 执行的是我们自定义的实现类 来做
        auth.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开始httpBasic认证
        /*
        http.httpBasic().and()
                .authorizeRequests() // 所有的请求都需要鉴权
                .anyRequest().authenticated(); // 任何请求都需要认证(登录)
         */

        // 鉴权认证配置
        http.authorizeRequests() //鉴权配置，所有请求需要鉴权
                .antMatchers("/login.html", "/login", "/js/*", "/favicon.ico").permitAll() // 配置允许通过的请求
                .anyRequest().authenticated();  // 除了上面的配置外，都需要认证(登录)才能访问

        // 使用表单进行登录
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")    // 定义登录表单的参数
//                .defaultSuccessUrl("/home")                                   // 登录成功后默认的重定向路径
                .successHandler(myAuthenticationSuccessHandler)                 // 自定义登录成功处理器
//                .failureForwardUrl("/error1")                                 // 登录失败后转发的路径
                .failureHandler(myAuthenticationFailureHandler);                // 自定义登录失败处理器

        // 认证和鉴权异常配置
        http.exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)   // 认证异常
                .accessDeniedHandler(myAccessDeniedHandler);            // 鉴权异常

        // 使用jwt的话，需要关闭session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 添加jwt过滤器到security过滤器链中
        http.addFilterAfter(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //退出成功后的处理器
        http.logout().logoutSuccessHandler(myLogoutSuccessHandler);

        //关闭CSRF跨域
        http.csrf().disable();
    }
}
