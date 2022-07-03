package com.wgx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author:wgx
 * version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3366.class, args);
    }
}
