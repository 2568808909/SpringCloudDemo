package com.ccb.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${server.port}")
    private int port;

    @Value("${spring.cloud.config.server.git.uri}")
    private String uri;

    @GetMapping("/get")
    public String get() {
        return port + "  " + uri;
    }
}
