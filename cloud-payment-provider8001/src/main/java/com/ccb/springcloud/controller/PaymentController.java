package com.ccb.springcloud.controller;

import com.ccb.springcloud.common.entities.CommonResult;
import com.ccb.springcloud.entities.Payment;
import com.ccb.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/create")
    @ResponseBody
    public CommonResult create() {
        int res = paymentService.create();
        if (res != 0) return new CommonResult(200, "创建成功", null);
        else return new CommonResult(444, "创建失败", null);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment res = paymentService.getPayment(id);
        if (res != null) return new CommonResult(200, "success from" + port, res);
        else return new CommonResult(444, "fail", null);
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(log::info);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("*****{} {} {}", instance.getHost(), instance.getPort(), instance.getInstanceId());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public Integer lb() {
        return port;
    }
}
