package com.wgx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * author:wgx
 * version:1.0
 */
@Service
@SuppressWarnings("unused")
public class PaymentService {
    public String paymentInfo_success(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",id=" + id + "_success\tO(∩_∩)O哈哈~";
    }

    //指定超时后调用的方法
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            //设置超时时间为3秒
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + ",id=" + id + "_timeout\tO(∩_∩)O哈哈~";
    }

    public String paymentInfo_timeoutHandler(@PathVariable("id") Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",id=" + id + "_timeout\to(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("----id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功:" + uuid;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试o(╥﹏╥)o\tid:" + id;
    }
}
