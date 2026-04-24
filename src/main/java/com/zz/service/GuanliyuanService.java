package com.zz.service;


import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.Guanliyuan;
import com.zz.entities.ResultData;
import com.zz.entities.model.LoginModel;
import com.zz.entities.model.ResetPwd;
import com.zz.entities.view.LoginView;
import com.zz.mapper.GuanliyuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Service
public class GuanliyuanService {
    @Autowired
    private GuanliyuanMapper guanliyuanMapper;

    public ResultData login(LoginModel loginModel, HttpServletRequest request) {
        Guanliyuan admin = guanliyuanMapper.selectOne(new QueryWrapper<Guanliyuan>().eq("username", loginModel.getUsername()));
        if (admin == null) {
            return ResultData.err("用户不存在");
        }
        if (!admin.getPassword().equals(SecureUtil.md5(loginModel.getPassword() + admin.getSalt()))) {
            return ResultData.err("密码不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("username", loginModel.getUsername());
        session.setAttribute("role", "admin");
        return ResultData.ok(new LoginView("admin", "系统管理员"));
    }

    public ResultData resetPwd(ResetPwd resetPwd, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        Guanliyuan guanliyuan = guanliyuanMapper.selectOne(new QueryWrapper<Guanliyuan>().eq("username", username));
        if (guanliyuan == null) {
            return ResultData.err("请先登录");
        }
        if (!guanliyuan.getPassword().equals(SecureUtil.md5(resetPwd.getOldpwd() + guanliyuan.getSalt()))) {
            return ResultData.err("原密码不正确");
        }
        //重置密码
        //创建随机数
        Random random = new Random();
        int a = random.nextInt();
        //将随机数加密
        String salt = SecureUtil.md5(String.valueOf(a));
        //将加密的密码和加密的随机数作为存入的数据库的密码
        String dbpassword = SecureUtil.md5(resetPwd.getNewpwd() + salt);

        guanliyuan.setSalt(salt);
        guanliyuan.setPassword(dbpassword);
        int i = guanliyuanMapper.updateById(guanliyuan);
        if (i == 1) {
            request.getSession(false).invalidate();
            return ResultData.ok("修改成功");
        }
        return ResultData.err("修改失败");
    }
}
