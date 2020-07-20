package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud
 *
 * @date:2020/7/18 0018 23:51
 * @author:liyang
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulMain80.class, args);
    }
}
