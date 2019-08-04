package com.yangjie.springcloud.yangjiecloudapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * EnableTransactionManagement开启简单事务注解，需要引入spring-boot-starter-jdbc
 * MapperScan扫描mapper文件，需要引入mybatis-spring-boot-starter
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.yangjie.springcloud.yangjiecloudapi.dao")
public class YangjiecloudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudApiApplication.class, args);
    }

}
