package com.ccb.springcloud.service.feign;

import com.ccb.springcloud.service.feign.fallback.PaymentHystrixFeignFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentHystrixFeignFallback.class)
//@RequestMapping("/payment") //RequestMapping 确实可以生效，但是使用Feign的Fallback时要去掉，不然启动就会报错
public interface PaymentHystrixFeign {

    @GetMapping("/payment/ok")
    String ok();

    @GetMapping("/payment/timeout")
    String timeout();
}
