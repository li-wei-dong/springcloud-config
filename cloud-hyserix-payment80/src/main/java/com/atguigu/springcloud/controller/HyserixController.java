package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HyserixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/20 0020 03:41
 * @author:liyang
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_NO_handler2")
public class HyserixController {

    @Resource
    private HyserixService hyserixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String infoOk = hyserixService.paymentInfo_ok(id);
        System.out.println("OK");
        return infoOk;

    }

    @GetMapping(value = "/consumer/payment/hystrix/No/{id}")
        @HystrixCommand(fallbackMethod = "paymentInfo_NO_handler",commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
        })
    public String paymentInfo_NO(@PathVariable("id") Integer id) {
        String infoNo = hyserixService.paymentInfo_NO(id);
        System.out.println("No");
        return infoNo;

    }
        public String paymentInfo_NO_handler(@PathVariable("id") Integer id){
            return "方法上访问超时请稍后再试80";
        }

//全局服务降级
    @GetMapping(value = "/consumer/payment/hystrix/No2/{id}")
    @HystrixCommand
    public String paymentInfo_NO2(@PathVariable("id") Integer id) {

        String infoNo = hyserixService.paymentInfo_NO(id);
        System.out.println("No");
        return infoNo;

    }
    public String paymentInfo_NO_handler2(){
        return "访问超时请稍后再试80q全局生效";
    }


}
