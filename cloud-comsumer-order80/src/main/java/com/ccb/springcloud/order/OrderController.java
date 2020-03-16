package com.ccb.springcloud.order;

import com.ccb.springcloud.common.entities.CommonResult;
import com.ccb.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //使用Eureka访问微服务，地址为服务的名称
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;

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

    @GetMapping("/lb")
    public Integer lb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.getInstance(instances);
        URI uri = instance.getUri();
        String url = uri.toString() + "/payment/lb";
        return restTemplate.getForObject(url, Integer.class);
    }
}
