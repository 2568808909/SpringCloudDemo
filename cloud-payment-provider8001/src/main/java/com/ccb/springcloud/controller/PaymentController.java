package com.ccb.springcloud.controller;

import com.ccb.springcloud.common.entities.CommonResult;
import com.ccb.springcloud.entities.Payment;
import com.ccb.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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
        if (res != null) return new CommonResult(200, "success", res);
        else return new CommonResult(444, "fail", null);
    }
}
