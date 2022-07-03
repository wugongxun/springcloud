package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudProviderHystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001.class, args);
    }
}
