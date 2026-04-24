package com.zz.service;

import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.entities.model.LoginModel;
import com.zz.entities.view.LoginView;
import com.zz.mapper.StudentMapper;
import com.zz.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@SuppressWarnings("all")
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> queryStudentRecordByPage(int page, int limit, String name) {
        List<Student> students = studentMapper.queryStudentRecordByPage((page - 1) * limit, limit, "%" + name + "%");
        return students;
    }

    public Student countStudentRecord(String name) {
        return studentMapper.countStudentRecord("%" + name + "%");


    }

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public Student queryStudentRecordById(Integer id) {
        Student student = studentMapper.queryStudentRecordById(id);
        return student;

    }

    public int updateStudentRecord(Student student) {
        return studentMapper.updateById(student);
    }

    public int deleteStudentRecordById(Integer id) {
        return studentMapper.deleteById(id);
    }

    public Long countStu() {
        return studentMapper.selectCount(null);
    }

    public ResultData login(LoginModel loginModel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", Common.STUDENT);
        return ResultData.ok(new LoginView(Common.STUDENT, "学生"));
    }
}
