package com.ccb.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RoundRobinLoadBalancer implements LoadBalancer {

    private AtomicInteger cyclicCount = new AtomicInteger(0);

    /**
     * 使用CAS的方式来获取下标
     * @param size 服务数量
     * @return 返回应该访问的服务下标
     */
    private int getIndex(int size) {
        int current, next;
        do {
            current = cyclicCount.get();
            next = (current + 1) % size;
        } while (!cyclicCount.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> list) {
        if (list == null || list.size() == 0) {
            throw new RuntimeException("注册中心中无相应服务");
        }
        int index = getIndex(list.size());
        return list.get(index);
    }
}
