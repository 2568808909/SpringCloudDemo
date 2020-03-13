package com.ccb.springcloud.service;

import com.ccb.springcloud.entities.Payment;

public interface PaymentService {

    int create();

    Payment getPayment(Long id);

}
