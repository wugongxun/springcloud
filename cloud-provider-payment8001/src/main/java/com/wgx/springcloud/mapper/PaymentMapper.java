package com.wgx.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgx.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
