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

    @Override
    //一下配置为，开启断路器，每10秒的十次请求中，失败率如果达到了60%则打开断路器，断路器打开后，即使正常连接到来后也会进行降级处理，一段时间过去后调用链路会自动恢复
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口周期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率
    })
    public String circuitBreakerTest(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数    "+id);
        }
        return Thread.currentThread().getName() + "ms O(∩_∩)O哈哈~"+id;
    }

    public String circuitBreakerFallback(Integer id){
        return "id不能为负数    "+id;
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
