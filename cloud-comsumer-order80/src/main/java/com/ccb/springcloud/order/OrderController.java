package com.ccb.springcloud.order;

import com.ccb.springcloud.common.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //使用Eureka访问微服务，地址为服务的名称
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/create")
    public CommonResult create() {
        return restTemplate.postForObject(
                PAYMENT_URL + "/payment/create",
                null,
                CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(
                PAYMENT_URL + "/payment/get/" + id,
                CommonResult.class);
    }
}
