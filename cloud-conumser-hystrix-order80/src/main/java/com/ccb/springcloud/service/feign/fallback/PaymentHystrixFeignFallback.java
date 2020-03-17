package com.ccb.springcloud.service.feign.fallback;

import com.ccb.springcloud.service.feign.PaymentHystrixFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * 统一为Feign接口的方法提供fallback方法，fallback方法不需要再写到业务类中，降低耦合度，
 * 即使业务代码中提供了@HystrixCommand服务降级，也会优先调用Feign的降级方法。
 */
@Component
public class PaymentHystrixFeignFallback implements PaymentHystrixFeign {
    @Override
    public String ok() {
        return "--PaymentHystrixFeignFallback ok ┭┮﹏┭┮";
    }

    @Override
    public String timeout() {
        return "--PaymentHystrixFeignFallback timeout ┭┮﹏┭┮";
    }
}
