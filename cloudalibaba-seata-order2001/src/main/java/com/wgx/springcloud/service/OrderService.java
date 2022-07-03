package com.wgx.springcloud.service;

import com.wgx.springcloud.bean.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
