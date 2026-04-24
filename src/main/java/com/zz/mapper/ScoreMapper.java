package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {
    List<Score> queryPage(int page, int limit, @Param("xueqi") String xueqi);

    Score countScore(@Param("xueqi") String xueqi);
}
