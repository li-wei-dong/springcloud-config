package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.HyserixServiceIFalbaakIpml;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service
 *
 * @date:2020/7/20 0020 03:42
 * @author:liyang
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-SERVICE",fallback = HyserixServiceIFalbaakIpml.class)
public interface HyserixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/No/{id}")
    public String paymentInfo_NO(@PathVariable("id") Integer id);
}
