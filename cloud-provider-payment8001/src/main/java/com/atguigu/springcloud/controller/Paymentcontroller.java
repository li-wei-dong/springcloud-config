package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.net.ssl.SSLServerSocket;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/17 0017 11:18
 * @author:liyang
 */

@RestController
@Slf4j
public class Paymentcontroller {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    //添加
    @PostMapping(value = "/payment/create")
    @ResponseBody
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        System.out.println(result);
        //log.info("ddd");
        if (result > 0) {
            return new CommonResult(200, "插入成功" + servicePort, result);
        } else {
            return new CommonResult(444, "插入失败" + servicePort, null);
        }
    }

    //查询
    @RequestMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("测试");
        //log.info("dddd");
        if (payment != null) {
            return new CommonResult(200, "查询成功  " + servicePort, payment);
        } else {
            return new CommonResult(444, "查询失败" + id + servicePort, null);
        }
    }

    //删除
    @RequestMapping(value = "/payment/delete/{id}")
    @ResponseBody
    public CommonResult deletePayment(@PathVariable("id") Integer id) {
        int result = paymentService.deletePayment(id);
        System.out.println(result);
        //log.info("ddd");
        if (result > 0) {
            return new CommonResult(200, "删除成功" + servicePort, result);
        } else {
            return new CommonResult(444, "删除失败" + servicePort, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> discoveryClientservices = discoveryClient.getServices();

        for (String discoveryClientservice : discoveryClientservices) {
            log.info("************discoveryClientservice" + discoveryClientservice);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getUri() + "\t" + instance.getPort() + "\t" + instance.getHost());

        }
        return this.discoveryClient;
    }

    //测试openfeign等待时间
    @GetMapping(value = "/payment/lb")
    public String getopenfeignLB() {
        return servicePort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            //睡眠3秒
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }


}
