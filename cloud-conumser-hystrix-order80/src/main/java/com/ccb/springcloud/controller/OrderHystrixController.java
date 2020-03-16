package com.ccb.springcloud.controller;

import com.ccb.springcloud.service.feign.PaymentHystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/order")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixFeign paymentHystrixFeign;

    @GetMapping("/ok")
    public String ok() {
        return paymentHystrixFeign.ok();
    }

    @GetMapping("/timeout")
    public String timeout() {
        return paymentHystrixFeign.timeout();
    }
}
