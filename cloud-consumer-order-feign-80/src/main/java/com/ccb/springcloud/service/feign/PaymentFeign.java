package com.ccb.springcloud.service.feign;

import com.ccb.springcloud.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CLOUD-PAYMENT-SERVICE") //配置需要调用的服务名，区分大小写
public interface PaymentFeign {

    @PostMapping("/payment/create")
    CommonResult create();

    @GetMapping("/payment/get/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    Integer timout();
}
