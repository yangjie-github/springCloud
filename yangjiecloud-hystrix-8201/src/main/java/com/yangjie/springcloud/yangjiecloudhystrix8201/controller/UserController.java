package com.yangjie.springcloud.yangjiecloudhystrix8201.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/9/6 20:59
 */
@RestController
public class UserController {

    @GetMapping("user/get")
    //若此方法报错，会执行processHystrix_Get方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public User getUserById() {
        User user = new User();
        user.setUsername("jie");
        throw new RuntimeException("测试hystrix");
    }

    public User processHystrix_Get() {
        User user = new User();
        user.setUsername("该用户不存在");
        return user;
    }
}
