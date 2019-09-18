package com.yangjie.springcloud.yangjiecloudhystrix8201.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangjie.springcloud.yangjiecloudapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author yangjie
 * 2019/9/6 20:59
 */
@RestController
public class UserController {

    @Autowired
    private UserClientService userClientService;

    @GetMapping("getUser/{name}")
    //若此方法报错，会执行processHystrix_Get方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String getUserById(@PathVariable String name) {

        String user = userClientService.getUserByName(name);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }

        return user;
    }

    public String processHystrix_Get(@PathVariable String name) {
        return "该用户不存在";
    }
}
