package com.yangjie.springcloud.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangjie
 * 2019/9/1 8:59
 */

//注意这个类不能放在componentMapper所扫描的包下面
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new MyRandomRule();
    }
}
