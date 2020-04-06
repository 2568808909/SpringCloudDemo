package com.ccb.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope  //引入该注解后会自动刷新配置，使用nacos作为配置中心后，发布新的配置后就会刷新客户端的配置，相当于整合了bus的功能
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/info")
    public String info() {
        return info;
    }
}
