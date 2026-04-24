package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    Teacher queryTeacherByWorkId(String workId);


    List<Teacher> queryTeacherRecordByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name);

    Teacher countsTeacherRecord(@Param("name") String name);

    int addTeacher(@Param("teacher") Teacher teacher);

    Teacher queryTeacherRecordById(Integer id);
}
