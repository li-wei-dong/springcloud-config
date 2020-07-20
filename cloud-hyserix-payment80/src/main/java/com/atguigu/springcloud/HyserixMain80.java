package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud
 *
 * @date:2020/7/20 0020 03:39
 * @author:liyang
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HyserixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HyserixMain80.class,args);
    }
}
