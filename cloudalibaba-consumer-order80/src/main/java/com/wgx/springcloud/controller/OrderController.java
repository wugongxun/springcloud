package com.wgx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * author:wgx
 * version:1.0
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/payment/nacos")
    public String nacos() {
        return restTemplate.getForObject(serverURL + "/payment/nacos", String.class);
    }
}
