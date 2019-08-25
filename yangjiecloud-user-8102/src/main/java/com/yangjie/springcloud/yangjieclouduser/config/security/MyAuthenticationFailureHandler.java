package com.yangjie.springcloud.yangjieclouduser.config.security;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangjie
 * 2019/8/24 12:21
 * 用户认证失败handler
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("status", 500);
            if ("USER_NAME_NOT_EXIST".equals(e.getMessage())) {
                jsonObject.put("msg", "USER_NAME_NOT_EXIST");
            } else if ("PASSWORD_ERROR".equals(e.getMessage())) {
                jsonObject.put("msg", "PASSWORD_ERROR");
            } else {
                jsonObject.put("msg", "ERROR");
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        httpServletResponse.getWriter().write(jsonObject.toString());
    }
}
