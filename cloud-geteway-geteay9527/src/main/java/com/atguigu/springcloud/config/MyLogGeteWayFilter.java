package com.atguigu.springcloud.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.config
 *
 * @date:2020/7/20 0020 19:06
 * @author:liyang
 * 全局过滤
 */

@Component
@Slf4j
public class MyLogGeteWayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("全局过滤器" + new Date());
        String payment = exchange.getRequest().getQueryParams().getFirst("name");

        if (payment == null) {
            log.info("非法用户不能访问");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
