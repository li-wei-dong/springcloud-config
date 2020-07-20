package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service.impl
 *
 * @date:2020/7/20 0020 02:17
 * @author:liyang
 */


public interface HystrixService {
    public String paymentInfo_ok(Integer id);
    public String paymentInfo_NO(Integer id);
    public String PaumentCircutBreaker(@PathVariable("id") Integer id);
}
