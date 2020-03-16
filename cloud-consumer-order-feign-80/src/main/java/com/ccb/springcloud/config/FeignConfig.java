package com.ccb.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level level() {
//        return Logger.Level.NONE; //默认级别，不显示日志
//        return Logger.Level.BASIC; //记录请求的方法，URL，响应状态码及执行时间
//        return Logger.Level.HEADERS; //除了BASIC中的信息外，还有请求头和响应头的信息
        return Logger.Level.FULL; //除了HEADERS中的信息外,还有请求和响应正文以及元数据
    }
}
