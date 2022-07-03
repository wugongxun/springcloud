package com.wgx.springcloud.controller;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/insert")
    public CommonResult<Payment> insert() {
        Payment payment = new Payment(null, "wgx");
        paymentService.insert(payment);
        return new CommonResult<Payment>(200, "ok", payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询:{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "ok,from " + serverPort, payment);
        } else {
            return new CommonResult<>(404, "not find");
        }
    }
}
