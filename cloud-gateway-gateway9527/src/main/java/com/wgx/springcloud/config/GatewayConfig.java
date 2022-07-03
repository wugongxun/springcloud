package com.wgx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author:wgx
 * version:1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //尝试使用/game定位到百度的游戏新闻http://news.baidu.com/game
        return routeLocatorBuilder.routes().route("payment_routh3", fn -> fn.path("/game").uri("http://news.baidu.com")).build();
    }
}
