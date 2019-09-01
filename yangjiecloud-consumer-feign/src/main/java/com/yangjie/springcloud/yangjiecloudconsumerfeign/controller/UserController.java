package com.yangjie.springcloud.yangjiecloudconsumerfeign.controller;

import com.yangjie.springcloud.yangjiecloudapi.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/9/1 11:20
 */
@RestController
public class UserController {

    @Autowired
    private UserClientService userClientService;

    @GetMapping("get")
    private String getUser() {

        return userClientService.getUser();
    }
}
