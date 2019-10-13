package com.yangjie.springcloud.yangjiecloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YangjiecloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudConfigClientApplication.class, args);
    }

}
