package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/20 0020 02:13
 * @author:liyang
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Hystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001.class,args);
    }
}
