package com.ccb.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("path_routes_ccb",
                        r-> r.path("/**")    //**代表匹配所有该uri下的路径
                                .uri("https://news.baidu.com"))
                .build();
    }
}
