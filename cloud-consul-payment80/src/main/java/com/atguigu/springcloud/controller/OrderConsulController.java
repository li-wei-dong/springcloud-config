package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.controller
 *
 * @date:2020/7/18 0018 21:16
 * @author:liyang
 */

@RestController
@Slf4j
public class OrderConsulController {

    private static final String ORDER_URL = "http://127.0.0.1:8006";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String create() {
        return restTemplate.getForObject(ORDER_URL + "/payment/consul/", String.class);
    }
}