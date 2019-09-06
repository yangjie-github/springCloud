package com.yangjie.springcloud.yangjiecloudhystrix8201;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableCircuitBreaker//熔断器支持
public class YangjiecloudHystrix8201Application {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudHystrix8201Application.class, args);
    }

}
