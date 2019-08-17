package com.yangjie.springcloud.yangjieclouduser.config;

import com.yangjie.springcloud.yangjieclouduser.intercepter.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yangjie
 * 2019/8/18 7:34
 */
@Configuration
public class SessionConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/*");
    }
}
