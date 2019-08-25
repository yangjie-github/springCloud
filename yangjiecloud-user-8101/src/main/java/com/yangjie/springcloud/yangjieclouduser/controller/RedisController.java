package com.yangjie.springcloud.yangjieclouduser.controller;

import com.yangjie.springcloud.yangjieclouduser.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/8/18 22:03
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("add")
    public void addKey() {
        redisUtils.set("yangjie", "liujia");
    }
}
