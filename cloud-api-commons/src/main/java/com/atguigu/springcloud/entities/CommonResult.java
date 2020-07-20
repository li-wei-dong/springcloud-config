package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:${Name}
 * Package:com.atguigu.springcloud.entities
 *
 * @date:2020/7/17 0017 10:47
 * @author:liyang
 * 返回前端的参数
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){

        this(code,message,null);
    }
}
