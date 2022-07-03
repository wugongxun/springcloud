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
public class CloudalibabaConsumerNacosOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder80.class, args);
    }
}
