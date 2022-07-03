package com.wgx.springcloud.service;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * author:wgx
 * version:1.0
 */
//value为调用的服务名，path为所有路径的前缀
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", path = "/payment")
public interface PaymentFeignService {
    //"/create"为调用的路径
    @GetMapping("/create")
    CommonResult create(Payment payment);

    @GetMapping("/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/timeout")
    String timeout();
}
