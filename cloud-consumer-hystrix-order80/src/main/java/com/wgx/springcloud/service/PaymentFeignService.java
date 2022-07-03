package com.wgx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", path = "/payment", fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {
    @GetMapping("/hystrix/success/{id}")
    String paymentInfo_success(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id);
}
