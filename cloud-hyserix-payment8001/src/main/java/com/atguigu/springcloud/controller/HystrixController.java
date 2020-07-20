package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixService;
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
 * @date:2020/7/20 0020 02:28
 * @author:liyang
 */

@RestController
@Slf4j
public class HystrixController {
    @Resource
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String infoOk = hystrixService.paymentInfo_ok(id);
        System.out.println("OK");
        return infoOk;

    }

    @GetMapping(value = "/payment/hystrix/No/{id}")
    public String paymentInfo_NO(@PathVariable("id") Integer id) {
        String infoNo = hystrixService.paymentInfo_NO(id);
        System.out.println("No");
        return infoNo;

    }
//服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentcircuitBreaker(@PathVariable("id") Integer id) {
        String infoNo = hystrixService.PaumentCircutBreaker(id);
        System.out.println("熔断");
        return infoNo;

    }

}
