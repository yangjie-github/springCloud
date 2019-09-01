package com.yangjie.springcloud.yangjiecloudconsumer;

import com.yangjie.springcloud.ribbonconfig.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//使用自定义的ribbon负载均衡策略, MICROSERVICECLOUD-USER需要负载均衡的微服务, configuration自定义的策略类
@RibbonClient(name = "MICROSERVICECLOUD-USER", configuration = MySelfRule.class)
public class YangjiecloudConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangjiecloudConsumerRibbonApplication.class, args);
    }

}
