package com.atguigu.fuZaiSuanFa;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:${Name}
 * Package:com.atguigu.fuZaiSuanFa
 *
 * @date:2020/7/19 0019 15:38
 * @author:liyang
 */

@RestController
public class MyselfRule {
    @Bean
    public IRule myRule() {
        //定义默认是轮询，换位随机 也可以变其他方式
        return new RandomRule();
    }
}
//在启动类上加上 @RibbonClient(name="服务名称",configurtion=MyselfRule.class)