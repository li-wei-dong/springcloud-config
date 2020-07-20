package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service
 *
 * @date:2020/7/17 0017 11:05
 * @author:liyang
 */


public interface PaymentService {

    //添加
    public int create(Payment payment);


    //删除
    public int deletePayment(@Param("id") Integer id);

    //查询
    public Payment getPaymentById(@Param("id") Long id);

}
