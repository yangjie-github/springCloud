package com.yangjie.springcloud.yangjiecloudconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/9/20 18:44
 */
@RestController
public class TestController {

    @GetMapping("get")
    public String get() {
        return "test";
    }
}
