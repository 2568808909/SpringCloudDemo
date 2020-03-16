package com.ccb.springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon核心组价IRule
 * 负载均衡算法(默认)原理：rest接口第几次请求 % 服务器集群总数量 =实际服务器位置下标 ，每次服务重新启动偶，rest计数都从1开始
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();//随机
        return new RoundRobinRule(); //轮询
//        return RetryRule(); //在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
//        return WeightedResponseTimeRule() //对RoundRobin的扩展，响应速度越快权重越大，越容易被选中
//        return BestAvailableRule(); //过滤多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量较小的进行访问
//        return ZoneAvoidanceRule(); //默认规则，符合判断server所在区域的性能和server的可用性来选择服务器
//        return AvailabilityFilteringRule();//过滤故障实例在选择并发较小实例。
    }
}
