package com.ccb.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope           //写上这个注解后，配置中心配置改变时，发送一个post请求到 http://localhost:3355/actuator/refresh 即可动态刷新配置，不用重启微服务
//这种动态刷新的方式适合小规模生产环境，如果微服务有多个的情况下，多次手动刷新也很麻烦，我们希望修改配置的时候，可以对所有使用改配置中西的微服务都被广播通知
public class ConfigController {

    @Value("${config.version}")
    private String version;

    @GetMapping("/get")
    public String get() {
        return version;
    }
}
