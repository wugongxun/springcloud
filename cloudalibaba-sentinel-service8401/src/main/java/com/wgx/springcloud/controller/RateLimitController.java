package com.wgx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.handler.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:wgx
 * version:1.0
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult(200, "ok", new Payment(1L, "wgx001"));
    }

    public CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t服务不可用");
    }

    @GetMapping("/globalExceptionHandler")
    @SentinelResource(value = "globalExceptionHandler",
            blockHandlerClass = GlobalExceptionHandler.class,
            blockHandler = "globalExceptionHandler1")
    //GlobalExceptionHandler中的globalExceptionHandler1方法
    public CommonResult globalExceptionHandler() {
        return new CommonResult(200, "ok", new Payment(1L, "wgx001"));
    }
}
