package com.ccb.springcloud.service.impl;

import com.ccb.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String ok() {
        return Thread.currentThread().getName() + "ok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") //配置断路器，如果执行时间>5s则启进行服务降级
    })
    public String timeout() {
        int time = 3000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " timeout " + time + "ms O(∩_∩)O哈哈~";
    }

    /**
     * 无论是方法执行超时还是抛出异常到外部，都会执行这个指定的回调函数，进行服务降级
     * 值得注意的是，Hystrix调用Fallback函数时，使用并不是服务器本来的线程池，而是自己维护了一个，
     * 这样做能更好的使Fallback与执行主业务的线程隔离
     *
     * @return
     */
    public String timeoutFallback() {
        return Thread.currentThread().getName() + " ┭┮﹏┭┮";
    }
}
