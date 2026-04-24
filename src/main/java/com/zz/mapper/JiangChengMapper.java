package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.JiangCheng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JiangChengMapper extends BaseMapper<JiangCheng> {
    List<JiangCheng> queryPage(int page, int limit, @Param("stuName") String stuName, @Param("type") String type);

    JiangCheng counts(@Param("stuName") String stuName, @Param("type") String type);
}
