package com.yangjie.springcloud.yangjiecloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * 2019/10/13 11:09
 */
@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("configClient")
    public String getConfigClient() {
        return "applicationName:" + applicationName + "-,eurekaServer:" + eurekaServer + "-,serverPort" + serverPort;
    }


}
