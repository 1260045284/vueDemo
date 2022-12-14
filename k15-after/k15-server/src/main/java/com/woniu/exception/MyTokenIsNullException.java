package com.woniu.exception;

import org.springframework.security.core.AuthenticationException;

public class MyTokenIsNullException extends AuthenticationException {
    public MyTokenIsNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyTokenIsNullException(String msg) {
        super(msg);
    }
}
