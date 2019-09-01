package com.yangjie.springcloud.yangjiecloudapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangjie
 * 2019/9/1 10:55
 * feign的接口
 *
 * Ribbon和Feign都是用于调用其他服务的，不过方式不同。
 *
 * 1.启动类使用的注解不同，Ribbon用的是@RibbonClient，Feign用的是@EnableFeignClients。
 *
 * 2.服务的指定位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明。
 *
 * 3.调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。
 *
 *   Feign则是在Ribbon的基础上进行了一次改进，采用接口的方式，将需要调用的其他服务的方法定义成抽象方法即可，
 *
 *   不需要自己构建http请求。不过要注意的是抽象方法的注解、方法签名要和提供服务的方法完全一致。
 */
//MICROSERVICECLOUD-USER 微服务名称，表示对哪一个微服务进行feign编程
@FeignClient(value = "MICROSERVICECLOUD-USER")
public interface UserClientService {

    //@GetMapping("/")这里的地址实际是服务提供者的controller地址
    @GetMapping("/")
    public String getUser();
}
