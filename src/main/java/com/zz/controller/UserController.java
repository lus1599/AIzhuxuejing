package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.entities.User;
import com.zz.entities.Yanzhengma;
import com.zz.entities.model.LoginModel;
import com.zz.entities.model.ResetPwd;
import com.zz.service.*;
import com.zz.utils.Common;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GuanliyuanService guanliyuanService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private YanzhengmaService yanzhengmaService;

    /**
     * 用户注册功能
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public ResultData register(@RequestBody User user) {
        if (user.getUsername() != null && !"".equals(user.getUsername())
                && user.getPassword() != null && !"".equals(user.getPassword())
                && user.getUserId() != null && !"".equals(user.getUserId())
        ) {
            //判断传过来任何一项都不为空
            return userService.register(user);
        } else {
            return new ResultData(408, "任何一项不能为空");
        }
    }

    /**
     * 登录功能
     *
     * @param request
     * @param loginModel
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public ResultData login(HttpServletRequest request, @RequestBody LoginModel loginModel) {
        if (loginModel.getUsername() == null || "".equals(loginModel.getUsername())
                || loginModel.getPassword() == null || "".equals(loginModel.getPassword())) {
            return new ResultData(400, "用户名、密码不能为空");
        }


//        //验证码验证
//        String uuid = loginModel.getUuid();
//        String code = loginModel.getCode();
//        if (!yanzhengmaService.check(new Yanzhengma(uuid, code))) {
//           return ResultData.err("验证码错误");
//        }

    //登录逻辑
        if (Common.ADMIN.equals(loginModel.getRole())) {
            //管理员登录
            return guanliyuanService.login(loginModel, request);
        }
        //普通用户
        //验证密码、角色
        if (!userService.login(loginModel, request)){
            return ResultData.err("用户名或密码不正确");
        }
        //密码正确
        if (Common.TEACHER.equals(loginModel.getRole())) {
            //老师
            return teacherService.login(loginModel, request);
        } else if (Common.STUDENT.equals(loginModel.getRole())) {
            //学生
            return studentService.login(loginModel, request);
        }
        return ResultData.err("请选择角色");
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "/front/login";
    }

    @ResponseBody
    @RequestMapping("/query_user_page")
    public ResultData queryUserByPage(int page, int limit, @RequestParam(value = "username", defaultValue = "") String username) {
        List<User> users = userService.queryUserByPage(page, limit, username);
        User user = userService.countUser(username);
        return new ResultData(0, "查询成功", users, page, user.getCounts(), limit);
    }

    //修改密码
    @ResponseBody
    @RequestMapping("/reset_pwd")
    public ResultData resetPwd(@RequestBody ResetPwd resetPwd, HttpServletRequest request){
        return userService.resetPwd(resetPwd, request);
    }

    //个人信息
    @ResponseBody
    @RequestMapping("/info")
    public ResultData info(HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");
        return userService.info(userId);
    }
}




