package com.ccb.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 使用代码配置网关，也可以在application,yml文件中配置
 */
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("path_routes_ccb",
                        //错误原因：这里配置为/**，使得所有路径都会跑到https://news.baidu.com，这里的优先级是比配置文件高的
                        r-> r.path("/guonei")    //**代表匹配所有该uri下的路径
                                .uri("https://news.baidu.com"))
                .build();
    }
}
