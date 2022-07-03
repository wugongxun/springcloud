package com.wgx.springcloud.service.impl;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.mapper.StorageMapper;
import com.wgx.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("扣减库存");
        storageMapper.decrease(productId, count);
        log.info("成功");
    }
}
