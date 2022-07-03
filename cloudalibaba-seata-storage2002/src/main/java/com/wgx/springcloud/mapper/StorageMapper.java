package com.wgx.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgx.springcloud.bean.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * author:wgx
 * version:1.0
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
