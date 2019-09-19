package com.yangjie.springcloud.yangjiecloudapi.service;

import com.yangjie.springcloud.yangjiecloudapi.service.UserClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author yangjie
 * 2019/9/18 11:37
 */
@Component
public class UserClientServiceFallBackFactory implements FallbackFactory<UserClientService> {

    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public String getUser() {
                return null;
            }

            @Override
            public String getUserByName(String name) {
                return "服务降级已关闭";
            }
        };
    }
}
