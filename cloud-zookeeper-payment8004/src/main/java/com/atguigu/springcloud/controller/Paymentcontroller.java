package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.UUID;


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


    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    //添加
    @GetMapping(value = "/payment/zk")
    @ResponseBody
    public String paymentzk() {
        log.info("servicePort="+servicePort);
        return servicePort+"-----"+ UUID.randomUUID().toString();

    }


}











