package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudalibabaSeataOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataOrder2001.class, args);
    }
}
