package com.wgx.springcloud.service.impl;

import com.wgx.springcloud.mapper.AccountMapper;
import com.wgx.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("扣减账户余额");
        accountMapper.decrease(userId, money);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("成功");
    }
}
