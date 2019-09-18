package com.yangjie.springcloud.yangjiecloudconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.yangjie.springcloud"})
@ComponentScan("com.yangjie.springcloud")
public class YangjiecloudConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudConsumerFeignApplication.class, args);
    }

}
