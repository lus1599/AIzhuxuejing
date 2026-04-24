package com.zz.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("student")
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private String age;
    /**
     * 学号
     */
    private String studentId;
    /**
     * 辅导员的工号
     */
    private String counselorWorkId;
    @TableField(exist = false)
    private Integer counts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCounselorWorkId() {
        return counselorWorkId;
    }

    public void setCounselorWorkId(String counselorWorkId) {
        this.counselorWorkId = counselorWorkId;
    }

    public Student() {
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Student(Integer id, String name, String sex, String age, String studentId, String counselorWorkId, Integer counts) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.studentId = studentId;
        this.counselorWorkId = counselorWorkId;
        this.counts = counts;
    }
}
