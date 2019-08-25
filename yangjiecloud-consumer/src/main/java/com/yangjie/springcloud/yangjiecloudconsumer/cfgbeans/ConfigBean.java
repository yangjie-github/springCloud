package com.yangjie.springcloud.yangjiecloudconsumer.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangjie
 * 2019/8/11 12:11
 * @Configuration 相当于applicationContext.xml， applicationContext.xml里面会注册bean
 */

@Configuration
public class ConfigBean {

    @Bean
    //使用ribbon配置客户端的负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
