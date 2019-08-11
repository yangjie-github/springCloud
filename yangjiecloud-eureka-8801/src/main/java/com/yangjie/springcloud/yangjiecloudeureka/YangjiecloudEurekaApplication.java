package com.yangjie.springcloud.yangjiecloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 标注该组件为euruka服务端
 */
@EnableEurekaServer
@SpringBootApplication
public class YangjiecloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudEurekaApplication.class, args);
    }

}
