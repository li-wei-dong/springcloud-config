package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.HyserixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service.impl
 *
 * @date:2020/7/20 0020 03:43
 * @author:liyang
 */

@Service(value = "HyserixService")
public class HyserixServiceIpml implements HyserixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池**"+Thread.currentThread().getName()+"**paymentInfo_ok**"+id+"**哈哈了";
    }



    @Override

    public String paymentInfo_NO(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "线程池**"+Thread.currentThread().getName()+"**a**"+id+"**错了";
    }


}
