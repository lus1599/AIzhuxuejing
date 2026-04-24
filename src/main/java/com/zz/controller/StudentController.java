package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/query_student_page")
    public ResultData queryStudentRecordByPage(int page, int limit, @RequestParam(value = "name", defaultValue = "") String name) {
        List<Student> students = studentService.queryStudentRecordByPage(page, limit, name);
        Student student = studentService.countStudentRecord(name);
        return new ResultData(0, "查询成功", students, page, student.getCounts(), limit);

    }

    //添加
    @RequestMapping("/add_student")
    public ResultData addStudentRecordInfo(@RequestBody Student student) {
        int i = studentService.addStudent(student);
        if (i == 1) {
            return new ResultData(200, "新增成功");
        }
        return new ResultData(400, "增加失败，别试了");
    }

    //查询学生信息
    @RequestMapping("/query_student_by_id")
    public ResultData queryStudentRecordInfoById(Integer id) {
        Student student = studentService.queryStudentRecordById(id);
        return new ResultData(200, "查询成功", student);
    }

    //修改
    @RequestMapping("/update_student")
    public ResultData updateStudentRecord(@RequestBody Student student) {
        int i = studentService.updateStudentRecord(student);
        if (i == 1) {
            return new ResultData(200, "修改成功");
        }
        return new ResultData(400, "修改不成功,别试了！");

    }

    //删除
    @RequestMapping("delete_student_by_id")
    public ResultData deleteStudentRecordById(Integer id) {
        int i = studentService.deleteStudentRecordById(id);
        if (i == 1) {
            return new ResultData(200, "删除成功");
        }
        return new ResultData(400, "删除不成功,别试了！");

    }
//
//    /**
//     * 学生
//     * @param page
//     * @param limit
//     * @param username1
//     * @return
//     */
//
//    @RequestMapping("/query_student_information")
//    public ResultData queryStudentInformationByPage(int page,int limit,String username1){
//        List<StudentInformation> studentInformations = studentInfoService.queryStudentInformationByPage(page,limit,username1);
//        StudentInformation studentInformation = studentInfoService.countStudentInformation(username1);
//        return  new ResultData(0,"查询成功",studentInformations,page,studentInformation.getCounts(),limit);
//
//    }
//
//
//    @RequestMapping("/add_address_info")
//    public  ResultData addStudentAddressInfo(@RequestBody StudentInformation studentInformation){
//        int i=studentInfoService.addStudentAddressInfo(studentInformation);
//        if (i== 1){
//            return  new ResultData(200,"新增成功");
//        }
//        return new ResultData(400,"增加失败，别试了");
//    }
}
