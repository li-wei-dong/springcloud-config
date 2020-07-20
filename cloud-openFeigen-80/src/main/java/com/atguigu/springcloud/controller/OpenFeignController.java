package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymenOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/19 0019 21:21
 * @author:liyang
 */

@RestController
@Slf4j
public class OpenFeignController {

    @Resource
    private PaymenOpenFeignService paymenOpenFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        System.out.println("openfeign也可以做负载均衡");
        return paymenOpenFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymenOpenFeignService.paymentFeignTimeout();
    }
}
