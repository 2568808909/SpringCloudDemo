package com.ccb.springcloud.order;

import com.ccb.springcloud.common.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(){
        return restTemplate.postForObject(
                "http://localhost:8001/payment/create",
                null,
                CommonResult.class);
    }
}
