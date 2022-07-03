package com.wgx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * author:wgx
 * version:1.0
 */

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/consul")
    public String paymentZk() {
        return "consul:" + serverPort + "\t" + UUID.randomUUID().toString().substring(0, 4);
    }
}
