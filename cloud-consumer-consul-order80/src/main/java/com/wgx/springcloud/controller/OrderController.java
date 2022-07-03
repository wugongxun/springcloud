package com.wgx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * author:wgx
 * version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String URL = "http://cloud-provider-payment-consul";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String orderZk() {
        return restTemplate.getForObject(URL + "/payment/consul", String.class);
    }
}
