package com.yangjie.springcloud.yangjiecloudconsumer.Controller;

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

    //整合ribbon后直接可以通过微服务名来访问
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-USER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get")
    private String getUser() {
        String url = REST_URL_PREFIX + "/";

        return restTemplate.getForObject(url, String.class);
    }


}
