package com.woniu.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.util.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //响应请求转码
        response.setContentType("application/json;charset=UTF-8");
        ResponseResult<Void> result = new ResponseResult<>(200, "退出成功");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
