package com.ccb.springcloud.controller;

import com.ccb.springcloud.service.feign.PaymentHystrixFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/order")
//可以在类头上配置一个全局默认的降级方法，这样注解上@HystrixCommand却没有指定fallbackMethod的方法降级时就会走默认的方法
//这样就不用一个方法配置一个fallbackMethod导致代码膨胀
@DefaultProperties(defaultFallback = "timeoutDefault",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
})
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixFeign paymentHystrixFeign;

    @GetMapping("/ok")
    public String ok() {
        return paymentHystrixFeign.ok();
    }

    @GetMapping("/timeout")
    @HystrixCommand //没有配置fallbackMethod属性，如果出现故障或超时走默认的fallback方法
    public String timeout() {
        return paymentHystrixFeign.timeout();
    }

    @GetMapping("/time")
    @HystrixCommand(fallbackMethod = "timeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") //配置断路器，如果执行时间>5s则启进行服务降级
    })
    public String time() {
        return paymentHystrixFeign.timeout();
    }

    public String timeoutFallback(){
        return "timeoutFallback";
    }

    //返回值还是要跟降级前的方法保持一致
    public String timeoutDefault() {
        return "80 fail";
    }
}
