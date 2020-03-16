package com.ccb.springcloud.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //使用Eureka访问微服务，地址为服务的名称
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @GetMapping("/zk")
    public String create() {
        return restTemplate.getForObject(
                PAYMENT_URL + "/payment/zk",
                String.class);
    }

}
