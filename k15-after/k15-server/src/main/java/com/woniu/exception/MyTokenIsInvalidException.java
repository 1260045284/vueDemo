package com.woniu.exception;

import org.springframework.security.core.AuthenticationException;

public class MyTokenIsInvalidException extends AuthenticationException {
    public MyTokenIsInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyTokenIsInvalidException(String msg) {
        super(msg);
    }
}
