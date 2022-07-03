package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashboard9001.class, args);
    }
}
