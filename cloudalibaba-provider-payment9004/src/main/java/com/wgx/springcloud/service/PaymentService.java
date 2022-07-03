package com.wgx.springcloud.service;

import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Service
public class PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    public void insert(Payment payment) {
        paymentMapper.insert(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.selectById(id);
    }
}
