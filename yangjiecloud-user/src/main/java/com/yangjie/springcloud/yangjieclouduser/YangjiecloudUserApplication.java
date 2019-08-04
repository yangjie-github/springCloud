package com.yangjie.springcloud.yangjieclouduser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//proxyTargetClass = true 不加会报错

@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
@MapperScan("com.yangjie.springcloud.yangjiecloudapi.dao")
public class YangjiecloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudUserApplication.class, args);
    }

}
