package com.wgx.springcloud.service;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

/**
 * author:wgx
 * version:1.0
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(444, "服务降级");
    }
}
