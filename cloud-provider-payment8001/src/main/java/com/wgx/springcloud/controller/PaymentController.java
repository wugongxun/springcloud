package com.wgx.springcloud.controller;

import com.wgx.springcloud.bean.CommonResult;
import com.wgx.springcloud.bean.Payment;
import com.wgx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    //插入
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:{}", result);
        if (result > 0) {
            return new CommonResult(100, "插入成功,server.port:" + serverPort, result);
        } else {
            return new CommonResult(200, "插入失败");
        }
    }
    //根据id查询
    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询id为{}的订单", id);
        if (payment == null) {
            return new CommonResult<>(200, "未查询到结果");
        } else {
            return new CommonResult<Payment>(100, "查询成功.server.port:" + serverPort, payment);
        }
    }

    @GetMapping("/discovery")
    public void discovery() {
        //获取总共有多少个微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}", service);
        }
        //获取某个微服务名称下有多少个实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("{}\t{}\t{}\t{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
    }

    @GetMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(3 * 1000);
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String testZipkin() {
        return "test,zipkin O(∩_∩)O哈哈~ " + serverPort;
    }

}
