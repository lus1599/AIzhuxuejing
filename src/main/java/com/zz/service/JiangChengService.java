package com.zz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.JiangCheng;
import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.mapper.JiangChengMapper;
import com.zz.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class JiangChengService {
    @Resource
    private JiangChengMapper jiangChengMapper;
    @Resource
    private StudentMapper studentMapper;

    public List<JiangCheng> queryPage(int page, int limit, String stuName, String type) {
        return jiangChengMapper.queryPage((page - 1) * limit, limit, "%" + stuName + "%", "%" + type + "%");
    }

    public JiangCheng counts(String stuName, String type) {
        return jiangChengMapper.counts("%" + stuName + "%", "%" + type + "%");
    }

    public ResultData add(JiangCheng jiangCheng, HttpServletRequest request) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", jiangCheng.getStuNumber()));
        if (student == null) {
            return ResultData.err("学号错误，查无此人");
        }
        jiangCheng.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        jiangCheng.setStuName(student.getName());
        jiangCheng.setHandlerWorkId((String) request.getSession().getAttribute("userId"));

        return jiangChengMapper.insert(jiangCheng) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("添加失败，请联系管理员");
    }

    public ResultData queryById(Integer id) {
        return ResultData.ok(jiangChengMapper.selectById(id));
    }

    public ResultData update(JiangCheng jiangCheng, HttpServletRequest request) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", jiangCheng.getStuNumber()));
        if (student == null) {
            return ResultData.err("学号错误，查无此人");
        }
        jiangCheng.setStuName(student.getName());
        jiangCheng.setHandlerWorkId((String) request.getSession().getAttribute("userId"));

        return jiangChengMapper.updateById(jiangCheng) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("修改失败，请联系管理员");
    }

    public ResultData delete(Integer id) {
        return jiangChengMapper.deleteById(id) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("删除失败，请联系管理员");
    }

    public ResultData selectOne(String stuNumber, String type) {
        List<JiangCheng> list = jiangChengMapper.selectList(new QueryWrapper<JiangCheng>().eq("stu_number", stuNumber).like("type", type));
        return new ResultData(0, "查询成功", list, 0, list.size(), 0);
    }
}
