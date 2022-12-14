package com.woniu.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.exception.MyTokenIsInvalidException;
import com.woniu.exception.MyTokenIsNullException;
import com.woniu.util.ResponseResult;
import com.woniu.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.error("登录错误", exception);

        ResponseResult result = null;

        if(exception instanceof UsernameNotFoundException) {                    //用户名不存在
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (exception instanceof AccountExpiredException) {              //账号过期
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (exception instanceof BadCredentialsException) {              //凭证不对   错误
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (exception instanceof CredentialsExpiredException) {          //密码过期
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (exception instanceof DisabledException) {                    //账号不可用
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (exception instanceof LockedException) {                      //账号锁定
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_LOCKED);
        } else if(exception instanceof MyTokenIsNullException) {
            result = ResponseResult.error(ResultCode.TOKEN_IS_NULL);            // token 为空
        } else if(exception instanceof MyTokenIsInvalidException) {
            result = ResponseResult.error(ResultCode.TOKEN_INVALID_EXCEPTION);  // token 不合法
        } else {
            result = ResponseResult.error(ResultCode.COMMON_FAIL);
        }

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
