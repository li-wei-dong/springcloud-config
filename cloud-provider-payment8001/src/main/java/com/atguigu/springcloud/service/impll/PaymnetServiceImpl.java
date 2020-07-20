package com.atguigu.springcloud.service.impll;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.service.impll
 *
 * @date:2020/7/17 0017 11:07
 * @author:liyang
 */

@Service("PaymentService")
public class PaymnetServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    //添加
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    //查询
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    //删除
    @Override
    public int deletePayment(Integer id){
        return paymentDao.deletePayment(id);

    }


}