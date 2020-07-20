package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud
 *
 * @date:2020/7/18 0018 21:11
 * @author:liyang
 */

@SpringBootApplication
@EnableDiscoveryClient   //consul和zookeeper作为注册中心使用
public class zkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(zkMain80.class,args);
    }
}
