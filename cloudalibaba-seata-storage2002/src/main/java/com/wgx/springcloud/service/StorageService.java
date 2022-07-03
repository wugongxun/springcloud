package com.wgx.springcloud.service;


/**
 * author:wgx
 * version:1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
