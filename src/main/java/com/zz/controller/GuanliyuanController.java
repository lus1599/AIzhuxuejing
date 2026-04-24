package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.entities.model.ResetPwd;
import com.zz.service.GuanliyuanService;
import com.zz.service.StudentService;
import com.zz.service.TeacherService;
import com.zz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/api/admin")
public class GuanliyuanController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;
    @Autowired
    private GuanliyuanService guanliyuanService;

    @ResponseBody
    @RequestMapping("/count")
    public ResultData count(){
        HashMap<String, Long> map = new HashMap<>();
        map.put("countStu", studentService.countStu());
        map.put("countTea", teacherService.countTea());
        map.put("countUser", userService.countUser());
        return ResultData.ok(map);
    }
    //重置密码
    @ResponseBody
    @RequestMapping("/reset_pwd")
    public ResultData resetPwd(@RequestBody ResetPwd resetPwd, HttpServletRequest request){
        return guanliyuanService.resetPwd(resetPwd, request);
    }
    //重置用户密码
    @ResponseBody
    @RequestMapping("/reset_user_pwd")
    public ResultData resetPwd(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "password") String password) {
        return userService.resetUserPwd(id, password);
    }
}
