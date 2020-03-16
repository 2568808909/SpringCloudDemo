package com.ccb.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced  //该注解赋予RestTemplate负载均衡的能力，在服务提供者有多个的情况下要加上
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
