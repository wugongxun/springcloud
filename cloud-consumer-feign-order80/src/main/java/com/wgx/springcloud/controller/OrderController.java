package com.wgx.springcloud.controller;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/create")
    CommonResult create(Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public String timeout() {
        return paymentFeignService.timeout();
    }
}
