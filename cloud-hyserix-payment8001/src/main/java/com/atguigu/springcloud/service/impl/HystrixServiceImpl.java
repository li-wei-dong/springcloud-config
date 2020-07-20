package com.atguigu.springcloud.service.impl;


import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.HystrixService;
import com.netflix.hystrix.config.HystrixCommandConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service.impl
 *
 * @date:2020/7/20 0020 02:18
 * @author:liyang
 */

@Service("HystrixService")
public class HystrixServiceImpl implements HystrixService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池**"+Thread.currentThread().getName()+"**paymentInfo_ok**"+id+"**哈哈了";
    }


    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_NO_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_NO(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池**"+Thread.currentThread().getName()+"**paymentInfo_NO**"+id+"**错了";
    }

    public String paymentInfo_NO_handler(Integer id){
        return "访问超时请稍后再试";
    }
    //*************************服务熔断

    @HystrixCommand(fallbackMethod ="paymentInfo_NO_handler2" ,commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled",value ="true" ), //是否开启
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold" ,value ="10" ),//10次访问
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value ="10000" ),//10秒
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value = "60") //失败率
    } )
    public String PaumentCircutBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        String randomUUID = IdUtil.randomUUID();
        return Thread.currentThread().getName()+"\t"+randomUUID;

    }

    public String paymentInfo_NO_handler2(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试";
    }

}
