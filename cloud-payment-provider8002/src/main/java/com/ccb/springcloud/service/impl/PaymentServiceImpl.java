package com.ccb.springcloud.service.impl;

import com.ccb.springcloud.dao.PaymentMapper;
import com.ccb.springcloud.entities.Payment;
import com.ccb.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create() {
        Payment payment=new Payment();
        payment.setSerial(UUID.randomUUID().toString());
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
