package com.yangjie.springcloud.yangjiecloudzuulgateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//EnableZuulProxy代理
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class YangjiecloudZuulGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudZuulGateway9527Application.class, args);
    }

}
