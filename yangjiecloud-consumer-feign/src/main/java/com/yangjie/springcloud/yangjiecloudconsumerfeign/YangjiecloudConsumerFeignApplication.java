package com.yangjie.springcloud.yangjiecloudconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.yangjie.springcloud.yangjiecloudapi"})
public class YangjiecloudConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudConsumerFeignApplication.class, args);
    }

}
