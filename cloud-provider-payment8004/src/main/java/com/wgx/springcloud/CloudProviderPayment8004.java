package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient//该注解用于向使用consul或者Zookeeper作为注册中心式注册服务
public class CloudProviderPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004.class, args);
    }
}
