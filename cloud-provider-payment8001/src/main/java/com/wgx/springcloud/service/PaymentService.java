package com.wgx.springcloud.service;

import com.wgx.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * 创建一个订单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id获取一个订单
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
