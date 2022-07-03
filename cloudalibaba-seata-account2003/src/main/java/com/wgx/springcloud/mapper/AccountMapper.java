package com.wgx.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgx.springcloud.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * author:wgx
 * version:1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
