package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.entities.User;
import com.zz.entities.Zxj;
import com.zz.mapper.StudentMapper;
import com.zz.mapper.UserMapper;
import com.zz.service.ZxjServicce;
import com.zz.utils.Common;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/zxj")
public class ZxjContoller {
    @Resource
    private ZxjServicce zxjServicce;
    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("/page")
    public ResultData queryUserByPage(int page, int limit, @RequestParam(value = "name",
            defaultValue = "") String name, HttpServletRequest request) {
        String role = (String) request.getSession().getAttribute("role");
        String userId = (String) request.getSession().getAttribute("userId");
        if (Common.STUDENT.equals(role)) {
            //学生，获取到的就是学号    需要获取辅导员的工号
            Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", userId));
            //将学生表中，辅导员的工号赋值给userId
            userId = student.getCounselorWorkId();
        }
        
        List<Zxj> zxjs = zxjServicce.queryZxjByPage(page, limit, name, userId);
        Zxj zxj = zxjServicce.countUser(name, userId);
        return new ResultData(0, "查询成功", zxjs, page, zxj.getCounts(), limit);
    }

    @RequestMapping("/add_zxj")
    public ResultData add(@RequestBody Zxj zxj, HttpServletRequest request) {
        return zxjServicce.add(zxj, request);
    }

    @RequestMapping("/update_zxj")
    public ResultData updateZxj(@RequestBody Zxj zxj) {
        return zxjServicce.updateZxj(zxj);
    }

    @RequestMapping("/query_zxj_by_id")
    public ResultData queryZxjById(Integer id) {
        return zxjServicce.queryZxjById(id);
    }

    @RequestMapping("/delete_zxj_by_id")
    public ResultData deleteZxjById(Integer id) {
        return zxjServicce.deleteZxjById(id);
    }
}
