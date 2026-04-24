package com.zz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.ResultData;
import com.zz.entities.Teacher;
import com.zz.entities.model.LoginModel;
import com.zz.entities.view.LoginView;
import com.zz.mapper.TeacherMapper;
import com.zz.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@SuppressWarnings("all")
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> queryTeacherRecordByPage(int page, int limit, String name) {
        List<Teacher> teachers = teacherMapper.queryTeacherRecordByPage((page - 1) * limit, limit, "%" + name + "%");
        return teachers;
    }

    public Teacher countsTeacherRecord(String name) {
        return teacherMapper.countsTeacherRecord("%" + name + "%");
    }

    public Teacher queryTeacherRecordById(Integer id) {
        Teacher teacher = teacherMapper.queryTeacherRecordById(id);
        return teacher;
    }

    public ResultData addTeacher(Teacher teacher) {
        if (teacherMapper.exists(new QueryWrapper<Teacher>().eq("work_id", teacher.getWorkId()))) {
            return ResultData.err("工号已存在");
        }
        int i = teacherMapper.addTeacher(teacher);
        return i == 1 ?
                ResultData.ok("新加成功") :
                ResultData.err("新加失败，请联系管理员");
    }

    public int updateTeacherRecord(Teacher teacher) {
        return teacherMapper.updateById(teacher);
    }

    public int deleteTeacherRecordById(Integer id) {
        return teacherMapper.deleteById(id);
    }


    public Long countTea() {
        return teacherMapper.selectCount(null);
    }

    public ResultData login(LoginModel loginModel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", Common.TEACHER);
        return ResultData.ok(new LoginView(Common.TEACHER, "教师"));
    }
}

