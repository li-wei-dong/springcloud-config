package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.dao
 *
 * @date:2020/7/17 0017 10:51
 * @author:liyang
 */
@Mapper
public interface PaymentDao {
    //增加
    public int create(Payment payment);

    //删除
    public int deletePayment(@Param("id") Integer id);
    //修改

    //查询
    public Payment getPaymentById(@Param("id") Long id);


}
