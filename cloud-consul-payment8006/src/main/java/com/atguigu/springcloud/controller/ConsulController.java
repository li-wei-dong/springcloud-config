package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/18 0018 23:31
 * @author:liyang
 */

@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    //添加
    @GetMapping(value = "/payment/consul")
    @ResponseBody
    public String PaymentConsul() {
        log.info("servicePort="+servicePort);
        return servicePort+"-----"+ UUID.randomUUID().toString();

    }

}
