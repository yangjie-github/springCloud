package com.yangjie.springcloud.yangjiecloudconsumerfeign.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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

    //使用ribbon配置客户端的负载均衡
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * Ribbon的源码地址：https://github.com/Netflix/ribbon
     * IRule：根据特定算法中从服务器列表中选取一个要访问的服务，Ribbon默认的算法为轮询算法；
     * Ribbon中的7中负载均衡算法：
     * （1）RoundRobinRule：轮询；
     * （2）RandomRule：随机；
     * （3）AvailabilityFilteringRule：会先过滤掉由于多次访问故障而处于断路器状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问；
     * （4）WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快的服务权重越大被选中的概率越大。刚启动时如果统计信息不足，则使用RoundRobinRule（轮询）策略，等统计信息足够，会切换到WeightedResponseTimeRule；
     * （5）RetryRule：先按照RoundRobinRule（轮询）策略获取服务，如果获取服务失败则在指定时间内进行重试，获取可用的服务；
     * （6）BestAvailableRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务；
     * （7）ZoneAvoidanceRule：复合判断Server所在区域的性能和Server的可用性选择服务器；
     */
    //如果有了此项配置，则会使用自己定义的算法。而不使用默认的轮询算法
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
