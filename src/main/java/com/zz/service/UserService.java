package com.zz.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.ResultData;
import com.zz.entities.Student;
import com.zz.entities.Teacher;
import com.zz.entities.User;
import com.zz.entities.model.LoginModel;
import com.zz.entities.model.ResetPwd;
import com.zz.entities.view.UserInfo;
import com.zz.mapper.StudentMapper;
import com.zz.mapper.TeacherMapper;
import com.zz.mapper.UserMapper;
import com.zz.utils.CheckParam;
import com.zz.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@SuppressWarnings("all")
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;

    public ResultData register(User user) {
        //判断用户名是否已经存在了
        User dbUser = userMapper.queryUserByName(user.getUsername());
        if (dbUser != null) {
            return ResultData.err("用户已经存在");
        }
        if (userMapper.queryUserByUserId(user.getUserId()) != null) {
            return ResultData.err("此工号或学号已被注册");
        }
        //密码是否符合格式要求
        if (!CheckParam.checkPwd(user.getPassword())) {
            return new ResultData(401, "密码为数字，字母组成，长度5-10");
        }
        //判断学号或工号是否在档案里面
        if (user.getUserId().length() == Common.LengthTeacherWorkId) {
            Teacher teacher = teacherMapper.queryTeacherByWorkId(user.getUserId());
            if (teacher == null) {//如果查出来为空则不是本校的老师
                return new ResultData(401, "非教职工不能注册");
            } else {//执行注册
                return this.userRegister(user);
            }
        } else if (user.getUserId().length() == Common.LengthStudentId) {//表示的是学生查学生档案表
            Student student = studentMapper.queryStudentByStuId(user.getUserId());
            if (student == null) {
                return new ResultData(401, "非本校学生不能注册");
            } else {
                return this.userRegister(user);
            }
        } else {//既不是6位也不是11位则提示学号或工号不对
            return new ResultData(401, "工号或学号错误");
        }
    }

    /**
     * 具体注册逻辑
     *
     * @param user
     * @return
     */
    public ResultData userRegister(User user) {
        //创建随机数
        Random random = new Random();
        int a = random.nextInt();
        //将随机数加密
        String salt = SecureUtil.md5(String.valueOf(a));
        //将页面传过来的密码加密
        String password = SecureUtil.md5(user.getPassword());
        //将加密的密码和加密的随机数作为存入的数据库的密码
        String dbpassword = SecureUtil.md5(password + salt);

        user.setPassword(dbpassword);
        user.setSalt(salt);
        user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        int rs = userMapper.insertUserInfo(user);
        if (rs == 1) {
            return new ResultData(200, "注册成功");
        } else {
            return new ResultData(406, "注册失败，请联系管理员");
        }

    }

    public boolean login(LoginModel loginModel, HttpServletRequest request) {
        //根据用户去查询用户表，看是否存在
        User dbUser = userMapper.queryUserByName((loginModel.getUsername()));
        if (dbUser != null) {
            if (Common.TEACHER.equals(loginModel.getRole()) && dbUser.getUserId().length() != Common.LengthTeacherWorkId) {
                //角色为老师，但是userid却不符合
                return false;
            } else if (Common.STUDENT.equals(loginModel.getRole()) && dbUser.getUserId().length() != Common.LengthStudentId) {
                //角色为学生，但是userid长度不符合
                return false;
            }

            String salt = dbUser.getSalt();//盐
            String dbPassword = dbUser.getPassword();//查寻数据库中的密码
            String password = loginModel.getPassword();//页面传过来的密码加密
            String s = SecureUtil.md5(password);//

            String newPassword = SecureUtil.md5(s + salt);
            if (newPassword.equals(dbPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", loginModel.getUsername());
                session.setAttribute("userId", dbUser.getUserId());
                return true;
            }
        }
        return false;
    }

    public Long countUser() {
        return userMapper.selectCount(null);
    }

    public List<User> queryUserByPage(int page, int limit, String username) {
        return userMapper.queryUserByPage((page - 1) * limit, limit, "%" + username + "%");
    }

    public User countUser(String username) {
        return userMapper.countsUser("%" + username + "%");
    }

    public ResultData resetUserPwd(Integer id, String password) {
        //创建随机数
        Random random = new Random();
        int a = random.nextInt();
        //将随机数加密
        String salt = SecureUtil.md5(String.valueOf(a));
        //将页面传过来的密码加密
        password = SecureUtil.md5(password);
        //将加密的密码和加密的随机数作为存入的数据库的密码
        String dbpassword = SecureUtil.md5(password + salt);

        User user = userMapper.selectById(id);
        if (user == null) {
            return ResultData.err("用户id错误");
        }
        user.setSalt(salt);
        user.setPassword(dbpassword);
        return userMapper.updateById(user) == 1 ?
                ResultData.ok("重置成功") :
                ResultData.err("重置失败");
    }

    public ResultData resetPwd(ResetPwd resetPwd, HttpServletRequest request) {
        if (!CheckParam.checkPwd(resetPwd.getNewpwd())) {
            return ResultData.err("密码为5到10位的数字或字母");
        }
        String username = (String) request.getSession().getAttribute("username");
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        //校验旧密码
        if (!user.getPassword().equals(SecureUtil.md5(SecureUtil.md5(resetPwd.getOldpwd()) + user.getSalt()))) {
            return ResultData.err("原密码不正确");
        }

        //创建随机数
        Random random = new Random();
        int a = random.nextInt();
        //将随机数加密
        String salt = SecureUtil.md5(String.valueOf(a));
        //将页面传过来的密码加密
        String password = SecureUtil.md5(resetPwd.getNewpwd());
        //将加密的密码和加密的随机数作为存入的数据库的密码
        String dbpassword = SecureUtil.md5(password + salt);

        user.setPassword(dbpassword);
        user.setSalt(salt);
        return userMapper.updateById(user) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("修改失败");
    }

    public ResultData info(String userId) {
        UserInfo userInfo = new UserInfo();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
        userInfo.setCreateTime(user.getCreateTime());
        if (Common.LengthTeacherWorkId == userId.length()) {
            //老师
            Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("work_id", userId));
            BeanUtil.copyProperties(teacher,userInfo);
            userInfo.setRole("老师");
        } else if (Common.LengthStudentId == userId.length()) {
            //学生
            Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", userId));
            BeanUtil.copyProperties(student, userInfo);
            userInfo.setRole("学生");
        }
        return ResultData.ok(userInfo);
    }
}

