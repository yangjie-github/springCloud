package com.yangjie.springcloud.yangjieclouduser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableTransactionManagement(proxyTargetClass = true) 事务管理，proxyTargetClass = true 不加会报错
 * @EnableEurekaClient 会注册进euruka服务
 * @EnableDiscoveryClient 服务发现
 */

//@EnableDiscoveryClient
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.yangjie.springcloud.yangjiecloudapi.dao")
public class YangjiecloudUser8102Application {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudUser8102Application.class, args);
    }

}
