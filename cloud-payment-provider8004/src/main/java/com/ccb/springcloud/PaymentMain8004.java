package com.ccb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用zookeeper作为注册中心时，在zookeeper上申请的是临时节点，
 * 也就是说zookeeper并不会向Eureka那般有自我保护机制，保留实例，
 * 一但发现服务无法连接，就断开连接
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
