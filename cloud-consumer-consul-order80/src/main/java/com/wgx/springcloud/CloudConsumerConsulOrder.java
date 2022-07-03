package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerConsulOrder {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerConsulOrder.class, args);
    }
}
