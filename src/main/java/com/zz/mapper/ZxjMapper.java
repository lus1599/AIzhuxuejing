package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Zxj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZxjMapper extends BaseMapper<Zxj> {
    List<Zxj> queryZxjByPage(int page, int limit, String name,String userId);

    Zxj count(String name,String userId);
}
