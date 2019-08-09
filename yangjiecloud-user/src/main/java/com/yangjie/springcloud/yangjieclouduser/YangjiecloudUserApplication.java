package com.yangjie.springcloud.yangjieclouduser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableTransactionManagement(proxyTargetClass = true) 事务管理，proxyTargetClass = true 不加会报错
 * @EnableEurekaClient 会注册进euruka服务
 */

@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.yangjie.springcloud.yangjiecloudapi.dao")
public class YangjiecloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudUserApplication.class, args);
    }

}
