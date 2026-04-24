package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/page")
public class PageController {

    //登录界面
    @RequestMapping("/sign_out")
    public String signOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "front/login";
    }

    //前台
    @RequestMapping("/front/index")
    public String index() {
        return "front/index";
    }

    //后台
    @RequestMapping("/admin/index")
    public String admin() {
        return "admin/index";
    }

    //后台欢迎界面
    @RequestMapping("/admin/welcome")
    public String welcome() {
        return "admin/welcome";
    }

    //教师信息管理
    @RequestMapping("/admin/teacher_management")
    public String teacherManagement() {
        return "admin/teacher_management";
    }

    //添加教师信息
    @RequestMapping("/admin/add_teacher")
    public String addTea() {
        return "admin/add_teacher";
    }

    /**
     * 修改教师信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/admin/edit_teacher")
    public ModelAndView editTeacherRecord(Integer id) {
        ModelAndView mav = new ModelAndView("/admin/edit_teacher");
        mav.addObject("id", id);
        return mav;
    }

    /**
     * 学生档案查询
     *
     * @return
     */
    @RequestMapping("/admin/student_management")
    public String studentRecordManagement() {
        return "/admin/student_management";
    }

    //添加学生
    @RequestMapping("/admin/add_student")
    public String addStudentInfo() {
        return "/admin/add_student";
    }

    /**
     * 接受的值是父页面id值
     *
     * @param id
     * @return
     */
    @RequestMapping("/admin/edit_student")
    public ModelAndView editStudentRecord(Integer id) {
        ModelAndView mav = new ModelAndView("/admin/edit_student");
        mav.addObject("id", id);
        return mav;
    }

    //管理员重置密码
    @RequestMapping("/admin/reset_pwd")
    public String restPwdAdmin() {
        return "/admin/reset_pwd";
    }

    //用户管理
    @RequestMapping("/admin/user_management")
    public String userManagement() {
        return "/admin/user_management";
    }

    //教师首页
    @RequestMapping("/front/tea_index")
    public String teaIndex() {
        return "/front/tea_index";
    }

    //奖学金管理
    @RequestMapping("/front/tea_jiangxuejin_management")
    public String jiangxujinManagement() {
        return "/front/tea_jiangxuejin_management";
    }

    //学生欢迎界面
    @RequestMapping("/front/welcome")
    public String frontWelcome() {
        return "/front/welcome";
    }

    //老师欢迎界面
    @RequestMapping("/front/welcom")
    public String frontWelcom() {
        return "/front/welcom";
    }

    //修改密码
    @RequestMapping("/front/reset_pwd")
    public String restPwd() {
        return "/front/reset_pwd";
    }

    //添加助学金信息
    @RequestMapping("/front/add_zxj")
    public String addZxj() {
        return "/front/tea_add_zxj";
    }

    //修改助学金信息
    @RequestMapping("/front/edit_zxj")
    public ModelAndView editZxj(Integer id) {
        ModelAndView mav = new ModelAndView("/front/tea_edit_zxj");
        mav.addObject("id", id);
        return mav;
    }

    //审批助学金申请
    @RequestMapping("/front/tea_apply_jiangxuejin")
    public String teaApplyJiangxuejin() {
        return "/front/tea_apply_jiangxuejin";
    }

    //学生端首页
    @RequestMapping("/front/stu_index")
    public String stuIndex() {
        return "/front/stu_index";
    }

    //学生申请奖学金
    @RequestMapping("/front/stu_apply_jiangxuejin")
    public String stuApplyJiangxuejin() {
        return "/front/stu_apply_jiangxuejin";
    }

    //申请助学金
    @RequestMapping("/front/apply_zxj")
    public ModelAndView applyZxj(Integer id) {
        ModelAndView mav = new ModelAndView("/front/stu_apply_zxj");
        mav.addObject("id", id);
        return mav;
    }

    //我的申请
    @RequestMapping("/front/my_apply")
    public String myApply() {
        return "/front/stu_my_apply";
    }

    //助学金学生名单
    @RequestMapping("/front/zxj_stu_list")
    public String applyPassList() {
        return "/front/zxj_stu_list";
    }

    //学生成绩管理
    @RequestMapping("/front/tea_score_management")
    public String scoreManagement() {
        return "/front/tea_score_management";
    }

    //添加成绩信息
    @RequestMapping("/front/tea_add_score_info")
    public String addScore() {
        return "/front/tea_add_score_info";
    }

    //修改成绩信息
    @RequestMapping("/front/edit_score")
    public ModelAndView editScore(Integer id) {
        ModelAndView mav = new ModelAndView("/front/tea_edit_score");
        mav.addObject("id", id);
        return mav;
    }

    //我的成绩
    @RequestMapping("/front/my_score")
    public String myScore() {
        return "/front/stu_my_score";
    }

    //个人信息
    @RequestMapping("/front/stu_my_info")
    public String myInfoStu() {
        return "/front/stu_my_info";
    }

    @RequestMapping("/front/tea_my_info")
    public String myInfoTea() {
        return "/front/tea_my_info";
    }

    //奖惩管理
    @RequestMapping("/front/tea_jc_management")
    public String jcManagement() {
        return "/front/tea_jc_management";
    }

    @RequestMapping("/front/tea_add_jc_info")
    public String addJc() {
        return "/front/tea_add_jc_info";
    }

    @RequestMapping("/front/edit_jc")
    public ModelAndView editJc(Integer id) {
        ModelAndView mav = new ModelAndView("/front/tea_edit_jc");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping("/front/my_jc")
    public String myJc() {
        return "/front/stu_my_jc";
    }
}
