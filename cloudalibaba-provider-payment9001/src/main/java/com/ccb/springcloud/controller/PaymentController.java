package com.ccb.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/nacos/{id}")
    public String console(@PathVariable("id") Integer id) {
        return "nacos register, serverPort:" + port + " id:" + id;
    }
}
