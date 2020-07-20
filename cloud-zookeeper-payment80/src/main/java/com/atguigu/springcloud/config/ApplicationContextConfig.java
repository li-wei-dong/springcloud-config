package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.config
 *
 * @date:2020/7/17 0017 17:01
 * 使用http远程调用，封装了 url requestMap  ResponseBean.class
 * 请求地址  请求参数 http相应转换为对象类型
 *
 * 作用是注入到容器中
 */

@Configuration
public class ApplicationContextConfig {



//    @LoadBalanced   //负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
