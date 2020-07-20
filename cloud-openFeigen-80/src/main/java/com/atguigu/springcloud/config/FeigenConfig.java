package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.config
 *
 * @date:2020/7/19 0019 22:53
 * @author:liyang
 */
//fengin日志打印
@Configuration
public class FeigenConfig {

    @Bean
    Logger.Level feignLonggerLeve(){
        return Logger.Level.FULL;
    }
}
