package com.wgx.springcloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgx.springcloud.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
