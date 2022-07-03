package com.wgx.springcloud.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * author:wgx
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_payment")
@KeySequence(value = "seq_payment", dbType = DbType.ORACLE)
public class Payment implements Serializable {
//    @TableId(type = IdType.AUTO)
    @TableId(type = IdType.INPUT)
    private Long id;
    private String serial;
}
