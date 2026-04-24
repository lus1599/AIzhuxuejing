package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 根据学号差学生档案
     * @param stuId
     * @return
     */
    Student queryStudentByStuId(String stuId);

    List<Student>queryStudentRecordByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name);

    Student countStudentRecord(@Param("name") String name);

    int addStudent(@Param("student") Student student);

    /**
     * 删除查询id
     * @param id
     * @return
     */
    Student queryStudentRecordById(Integer id);
}
