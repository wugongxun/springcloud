package com.wgx.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wgx.springcloud.bean.CommonResult;

/**
 * author:wgx
 * version:1.0
 */
public class GlobalExceptionHandler {
    public static CommonResult globalExceptionHandler1(BlockException exception) {
        return new CommonResult(444, exception.getMessage() + "\tglobalExceptionHandler1");
    }
    public static CommonResult globalExceptionHandler2(BlockException exception) {
        return new CommonResult(444, exception.getMessage() + "\tglobalExceptionHandler2");
    }
}
