package com.wgx.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author:wgx
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //状态码，200成功
    private Integer code;
    //信息
    private String message;
    //传送的数据
    private T data;

    //两个参数的构造器
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
