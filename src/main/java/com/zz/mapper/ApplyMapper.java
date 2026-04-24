package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {
    List<Apply> queryApplyByPage(int page, int limit, String workId);

    Apply countApply(String workId);
}
