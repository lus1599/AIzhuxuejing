package com.zz.controller;

import com.zz.entities.JiangCheng;
import com.zz.entities.ResultData;
import com.zz.service.JiangChengService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/jc")
public class JiangChengController {
    @Resource
    private JiangChengService jiangChengService;

    @RequestMapping("/page")
    public ResultData page(int page, int limit,
                           @RequestParam(value = "stuName", defaultValue = "") String stuName,
                           @RequestParam(value = "type", defaultValue = "") String type) {
        List<JiangCheng> jiangChengList = jiangChengService.queryPage(page, limit, stuName, type);
        JiangCheng jiangCheng = jiangChengService.counts(stuName, type);
        return new ResultData(0, "查询成功", jiangChengList, page, jiangCheng.getCounts(), limit);
    }

    @RequestMapping("/add")
    public ResultData add(@RequestBody JiangCheng jiangCheng, HttpServletRequest request) {
        return jiangChengService.add(jiangCheng, request);
    }

    @RequestMapping("/query_jc_by_id")
    public ResultData queryById(Integer id) {
        return jiangChengService.queryById(id);
    }

    @RequestMapping("/update")
    public ResultData update(@RequestBody JiangCheng jiangCheng, HttpServletRequest request) {
        return jiangChengService.update(jiangCheng, request);
    }

    @RequestMapping("/del/{id}")
    public ResultData del(@PathVariable Integer id) {
        return jiangChengService.delete(id);
    }

    @RequestMapping("/one")
    public ResultData one(HttpServletRequest request, @RequestParam(value = "type", defaultValue = "") String type) {
        //学号
        String stuNumber = (String) request.getSession().getAttribute("userId");
        return jiangChengService.selectOne(stuNumber, type);
    }
}
