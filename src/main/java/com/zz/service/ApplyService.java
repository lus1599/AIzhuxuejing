package com.zz.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.*;
import com.zz.entities.model.ApplyModel;
import com.zz.entities.view.ApplyView;
import com.zz.mapper.ApplyMapper;
import com.zz.mapper.StudentMapper;
import com.zz.mapper.UserMapper;
import com.zz.mapper.ZxjMapper;
import com.zz.utils.Common;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ApplyService {
    @Resource
    private ApplyMapper applyMapper;
    @Resource
    private ZxjMapper zxjMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private StudentMapper studentMapper;

    public ResultData page(int page, int limit, String workId) {
        List<Apply> applyList = applyMapper.queryApplyByPage((page - 1) * limit, limit, workId);
        Apply apply = applyMapper.countApply(workId);
        LinkedList<ApplyView> views = new LinkedList<>();
        for (Apply a : applyList) {
            Zxj zxj = zxjMapper.selectById(a.getZxjId());
            User user = userMapper.selectById(a.getUserId());
            Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", user.getUserId()));
            if (zxj == null || student == null) {
                if (apply.getCounts() > 0) {
                    apply.setCounts(apply.getCounts() - 1);
                }
                continue;
            }
            ApplyView view = new ApplyView();
            BeanUtil.copyProperties(a, view);
            view.setStuName(student.getName());
            view.setZxjName(zxj.getZxjName());
            views.add(view);
        }
        return new ResultData(0, "查询成功", views, page, apply.getCounts(), limit);
    }

    public ResultData stuApplyZxj(String username, ApplyModel applyModel) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        Zxj zxj = zxjMapper.selectById(applyModel.getZxjId());
        List<Apply> applyList = applyMapper.selectList(new QueryWrapper<Apply>().eq("user_id", user.getId())
                .eq("zxj_id", applyModel.getZxjId()));
        for (Apply apply : applyList) {
            if (apply.getStatus().equals("通过")) {
                return ResultData.err("已通过，不能重复申请");
            }
            if (apply.getStatus().equals("待审核")) {
                return ResultData.err("待审核中，不能重复提交");
            }
        }
        //可以提交
        Apply apply = new Apply();
        apply.setApplyTime(new Date());
        apply.setApplyTiaojian(applyModel.getApplyTiaojian());
        apply.setImg(applyModel.getImg());
        apply.setZxjId(applyModel.getZxjId());
        apply.setStatus("待审核");
        apply.setUserId(String.valueOf(user.getId()));
        apply.setTeaWorkId(zxj.getWorkId());

        return applyMapper.insert(apply) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("申请失败，请联系管理员");
    }

    public ResultData pass(Integer id) {
        Apply apply = applyMapper.selectById(id);
        apply.setStatus("通过");
        return applyMapper.updateById(apply) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("操作失败");
    }

    public ResultData nopass(Integer id) {
        Apply apply = applyMapper.selectById(id);
        apply.setStatus("不通过");
        return applyMapper.updateById(apply) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("操作失败");
    }

    public ResultData myApply(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        List<Apply> applyList = applyMapper.selectList(new QueryWrapper<Apply>().eq("user_id", user.getId()));
        LinkedList<ApplyView> list = new LinkedList<>();
        for (Apply apply : applyList) {
            Zxj zxj = zxjMapper.selectById(apply.getZxjId());
            if (zxj == null){
                continue;
            }
            ApplyView applyView = new ApplyView();
            BeanUtil.copyProperties(apply, applyView);
            applyView.setZxjName(zxj.getZxjName());
            list.add(applyView);
        }
        return new ResultData(0, "查询成功", list, 0, list.size(), 0);
    }

    //助学金学生名单
    public ResultData zxjStuList(String userId){
        if (Common.LengthStudentId.equals(userId.length())){
            //当前登录的是学生，需要辅导员的工号
            Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", userId));
            //将辅导员的工号重新赋值给userId
            userId = student.getCounselorWorkId();
        }
        //查询通过审核的学生名单
        List<Apply> applyList = applyMapper.selectList(new QueryWrapper<Apply>().eq("tea_work_id", userId).eq("status", "通过"));
        LinkedList<ApplyView> list = new LinkedList<>();
        for (Apply apply : applyList) {
            Zxj zxj = zxjMapper.selectById(apply.getZxjId());
            User user = userMapper.selectById(apply.getUserId());
            Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", user.getUserId()));
            if (zxj == null || student == null) {
                if (apply.getCounts() > 0) {
                    apply.setCounts(apply.getCounts() - 1);
                }
                continue;
            }
            ApplyView applyView = new ApplyView();
            BeanUtil.copyProperties(apply, applyView);
            applyView.setZxjName(zxj.getZxjName());
            applyView.setStuName(student.getName());
            list.add(applyView);
        }
        return new ResultData(0, "查询成功", list, 0, list.size(), 0);
    }
}
