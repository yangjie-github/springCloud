package com.yangjie.springcloud.yangjiecloudeureka8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class YangjiecloudEureka8802Application {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudEureka8802Application.class, args);
    }

}
