package com.yangjie.springcloud.yangjieclouduser.controller;

import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import com.yangjie.springcloud.yangjieclouduser.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangjie
 * 2019/8/4 13:50
 */
@RestController
@RequestMapping("user")
public class UserController {

    //服务发现，或者在主启动类上加标签//@EnableDiscoveryClient
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("get/{id}")
    public String getUserById(@PathVariable String id) {
        User user = userService.selectByPrimaryKey(id);
        return user.getId() + "---" + user.getUserName() + "---" + user.getPassword();
    }

    /**
     * 别人调用我，可以知道我这个服务的描述信息，也可以查询到注册进eureka的所有微服务
     * @return discoveryClient
     */
    @GetMapping("info")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = discoveryClient.getInstances("yangjiecloud-user");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost()
                    + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }
}
