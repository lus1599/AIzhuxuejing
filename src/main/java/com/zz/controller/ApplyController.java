package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.entities.model.ApplyModel;
import com.zz.service.ApplyService;
import com.zz.utils.Common;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @RequestMapping("/page")
    public ResultData page(int page, int limit, HttpServletRequest request){
        String workId = (String) request.getSession().getAttribute("userId");
        return applyService.page(page, limit, workId);
    }

    @RequestMapping("/stu_apply_zxj")
    public ResultData stuApplyZxj(HttpServletRequest request, @RequestBody ApplyModel applyModel){
        String username = (String) request.getSession().getAttribute("username");
        return applyService.stuApplyZxj(username, applyModel);
    }

    @RequestMapping("/pass")
    public ResultData pass(Integer id){
        return applyService.pass(id);
    }

    @RequestMapping("/nopass")
    public ResultData nopass(Integer id){
        return applyService.nopass(id);
    }

    @RequestMapping("/my_apply")
    public ResultData myApply(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        return applyService.myApply(username);
    }

    //助学金学生名单
    @RequestMapping("/apply_pass_stu_list")
    public ResultData zxjStuList(HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");
        return applyService.zxjStuList(userId);
    }
}
