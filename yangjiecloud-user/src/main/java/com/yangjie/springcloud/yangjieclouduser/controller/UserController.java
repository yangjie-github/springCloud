package com.yangjie.springcloud.yangjieclouduser.controller;

import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import com.yangjie.springcloud.yangjieclouduser.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/8/4 13:50
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("get/{id}")
    public String getUserById(@PathVariable String id) {
        User user = userService.selectByPrimaryKey(id);
        return user.getId() + "---" + user.getUserName() + "---" + user.getPassword();
    }
}
