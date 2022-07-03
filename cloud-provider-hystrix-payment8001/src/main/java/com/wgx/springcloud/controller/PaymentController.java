package com.wgx.springcloud.controller;

import com.wgx.springcloud.service.PaymentService;
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
@RequestMapping("/payment")
@SuppressWarnings("unuse")
public class PaymentController {
    @Resource
    private PaymentService paymentService;


    @GetMapping("/hystrix/success/{id}")
    public String paymentInfo_success(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_success(id);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_timeout(id);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }

}
