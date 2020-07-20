package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.HyserixService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service.impl
 *
 * @date:2020/7/20 0020 11:52
 * @author:liyang
 */

@Component
public class HyserixServiceIFalbaakIpml implements HyserixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "服务器8001宕机";
    }

    @Override
    public String paymentInfo_NO(Integer id) {
        return "服务器8001宕机";
    }
}
