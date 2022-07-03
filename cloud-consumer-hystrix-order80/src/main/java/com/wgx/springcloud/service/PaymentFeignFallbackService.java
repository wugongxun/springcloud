package com.wgx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallbackService implements PaymentFeignService{
    @Override
    public String paymentInfo_success(Integer id) {
        return "PaymentFeignFallbackService_paymentInfo_success_o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "PaymentFeignFallbackService_paymentInfo_timeout_o(╥﹏╥)o";
    }
}
