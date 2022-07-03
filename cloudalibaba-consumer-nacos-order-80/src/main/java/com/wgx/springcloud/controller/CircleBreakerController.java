package com.wgx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler",
                    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(serverURL + "/payment/get/" + id, CommonResult.class);
        if (id == 6) {
            throw new IllegalArgumentException("非法的参数, o(╥﹏╥)o");
        } else if (result.getData() == null) {
            throw new NullPointerException("未查询到记录, o(╥﹏╥)o");
        }
        return result;
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult<>(444, "blockHandler:" + e.getMessage());
    }
    public CommonResult<Payment> fallbackHandler(@PathVariable("id") Long id, Exception e) {
        return new CommonResult<>(444, "fallbackHandler:" + e.getMessage());
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
