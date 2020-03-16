package com.ccb.springcloud.service.impl;

import com.ccb.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String ok() {
        return "ok";
    }

    @Override
    public String timeout() {
        int time = 3000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout " + time + "s";
    }
}
