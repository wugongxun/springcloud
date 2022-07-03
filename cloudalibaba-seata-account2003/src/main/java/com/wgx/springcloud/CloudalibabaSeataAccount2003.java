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
public class CloudalibabaSeataAccount2003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataAccount2003.class, args);
    }
}
