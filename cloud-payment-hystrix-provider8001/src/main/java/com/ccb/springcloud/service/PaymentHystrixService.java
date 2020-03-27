package com.ccb.springcloud.service;

public interface PaymentHystrixService {

    String ok();

    String timeout();

    String circuitBreakerTest(Integer id);
}
