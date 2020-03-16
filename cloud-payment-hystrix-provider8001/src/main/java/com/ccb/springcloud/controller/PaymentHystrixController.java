package com.ccb.springcloud.controller;

import com.ccb.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok")
    public String ok() {
        return paymentHystrixService.ok();
    }

    @GetMapping("/timeout")
    public String timeout() {
        return paymentHystrixService.timeout();
    }
}
