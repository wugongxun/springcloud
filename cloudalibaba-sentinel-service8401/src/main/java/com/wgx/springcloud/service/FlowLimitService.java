package com.wgx.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * author:wgx
 * version:1.0
 */
@Service
public class FlowLimitService {
    //定义资源doSomething
//    @SentinelResource(value = "doSomething", blockHandler = "handlerException")
    public void doSomething() {
        System.out.println("do something...");
    }
    public String handlerException(BlockException ex) {
        return ex.getClass().getCanonicalName();
    }
}
