package com.yangjie.springcloud.yangjieclouduser.config.security;

import com.yangjie.springcloud.yangjieclouduser.controller.ValidateCodeController;
import com.yangjie.springcloud.yangjieclouduser.entity.ImageCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangjie
 * 2019/8/24 16:03
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenctiationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    // 过滤 逻辑
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 是一个登陆请求
        if (StringUtils.equals("/login", request.getRequestURI())
                && StringUtils.equalsIgnoreCase(request.getMethod(), "POST")) {
            try {
                validate(new ServletWebRequest(request));
            } catch (AuthenticationServiceException e) {
                // 有异常就返回自定义失败处理器
                authenctiationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        // 不是一个登录请求，不做校验 直接通过
        filterChain.doFilter(request, response);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);

        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码不能为空！");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpire()) {
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);

    }

    public AuthenticationFailureHandler getAuthenctiationFailureHandler() {
        return authenctiationFailureHandler;
    }

    public void setAuthenctiationFailureHandler(AuthenticationFailureHandler authenctiationFailureHandler) {
        this.authenctiationFailureHandler = authenctiationFailureHandler;
    }
}
