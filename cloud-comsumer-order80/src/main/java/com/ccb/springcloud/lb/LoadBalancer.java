package com.ccb.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 模拟负载均衡
 */
public interface LoadBalancer {

    ServiceInstance getInstance(List<ServiceInstance> list);
}
