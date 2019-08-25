package com.yangjie.springcloud.yangjieclouduser.config.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author yangjie
 * 2019/8/24 20:01
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7932793974645209799L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
