package com.yangjie.springcloud.yangjieclouduser.config;

import com.yangjie.springcloud.yangjieclouduser.intercepter.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yangjie
 * 2019/8/18 7:34
 */
@Configuration
//public class WebMvcConfig implements WebMvcConfigurer 若失效，实现这个方法
public class SessionConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SysInterceptor getSysInterceptor() {
        return new SysInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSysInterceptor()).addPathPatterns("/**");
    }
}
