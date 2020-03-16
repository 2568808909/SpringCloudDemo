package com.ccb.springcloud.service.feign;

import com.ccb.springcloud.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeign {

    @PostMapping("/create")
    CommonResult create();

    @GetMapping("/get/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);
}
