package com.wgx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wgx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "paymentInfo_Global_timeoutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
})
public class OrderHystrixController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/hystrix/success/{id}")
    public String paymentInfo_success(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_success(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    //指定超时后调用的方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
//            //设置超时时间为3秒
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_timeout(id);
    }

    public String paymentInfo_Global_timeoutHandler() {
        return "global消费端线程池:" + Thread.currentThread().getName() + "_timeout\to(╥﹏╥)o";
    }
}
