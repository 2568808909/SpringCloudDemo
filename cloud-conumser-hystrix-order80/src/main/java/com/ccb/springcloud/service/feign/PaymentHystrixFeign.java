package com.ccb.springcloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentHystrixFeign {

    @GetMapping("/ok")
    String ok();

    @GetMapping("/timeout")
    String timeout();
}
