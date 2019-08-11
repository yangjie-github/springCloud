package com.yangjie.springcloud.yangjiecloudconsumer.Controller;

import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangjie
 * 2019/8/11 12:38
 */
@RestController
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get")
    private String getUser() {
        String url = "http://localhost:8101/user/get/123456";

        return restTemplate.getForObject(url, String.class);
    }
}
