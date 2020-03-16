package com.ccb.springcloud.controller;

import com.ccb.springcloud.common.entities.CommonResult;
import com.ccb.springcloud.service.feign.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
