package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.entities.Teacher;
import com.zz.service.TeacherService;
import com.zz.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tea")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //分页查询教师信息
    @RequestMapping("/query_teacher_page")
    public ResultData queryTeacherRecordByPage(int page, int limit,
                                               @RequestParam(name = "name", defaultValue = "") String name) {
        List<Teacher> teachers = teacherService.queryTeacherRecordByPage(page, limit, name);
        Teacher teacher = teacherService.countsTeacherRecord(name);
        return new ResultData(0, "查询成功", teachers, page, teacher.getCounts(), limit);
    }
    //添加教师
    @RequestMapping("/add_teacher")
    public ResultData addTeacherRecordInfo(@RequestBody Teacher teacher) {
        if (teacher.getWorkId().length() != Common.LengthTeacherWorkId){
            return ResultData.err("工号格式不正确");
        }
        return teacherService.addTeacher(teacher);
    }
    //查询教师信息
    @RequestMapping("/query_teacher_by_id")
    public ResultData queryTeacherRecordInfoById(Integer id) {
        Teacher teacher = teacherService.queryTeacherRecordById(id);
        return new ResultData(200, "查询成功", teacher);
    }
    //修改
    @RequestMapping("/update_teacher")
    public ResultData updateTeacherRecord(@RequestBody Teacher teacher) {
        int i = teacherService.updateTeacherRecord(teacher);
        if (i == 1) {
            return new ResultData(200, "修改成功");
        }
        return new ResultData(400, "修改不成功,别试了！");

    }
    //删除
    @RequestMapping("/delete_teacher_by_id")
    public ResultData deleteTeacherRecordById(Integer id) {
        int i = teacherService.deleteTeacherRecordById(id);
        if (i == 1) {
            return new ResultData(200, "删除成功");
        }
        return new ResultData(400, "删除不成功,别试了！");

    }
}

