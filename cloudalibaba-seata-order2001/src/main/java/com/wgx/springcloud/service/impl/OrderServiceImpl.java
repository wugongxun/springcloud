package com.wgx.springcloud.service.impl;

import com.wgx.springcloud.bean.Order;
import com.wgx.springcloud.mapper.OrderMapper;
import com.wgx.springcloud.service.AccountService;
import com.wgx.springcloud.service.OrderService;
import com.wgx.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "wgx-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("新建订单");
        orderMapper.insert(order);
        log.info("成功");
        log.info("减少库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("成功");
        log.info("减少账户金额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("成功");
        log.info("修改订单状态");
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("成功");
    }
}
