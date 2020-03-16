package com.ccb.springcloud.controller;

import com.ccb.springcloud.common.entities.CommonResult;
import com.ccb.springcloud.service.feign.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    @Autowired
    private PaymentFeign paymentFeign;

    @PostMapping("/create")
    public CommonResult create() {
        return paymentFeign.create();
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return paymentFeign.getPayment(id);
    }

    @GetMapping("/timeout")
    public Integer timeout() {
        return paymentFeign.timout();
    }
}
