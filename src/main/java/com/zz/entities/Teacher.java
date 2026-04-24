package com.zz.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("teacher")
public class Teacher {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    private  String name;
    private  String sex;
    private  String age;
    /**
     * 工号
     */
    private  String workId;
    @TableField(exist = false)
    private Integer counts;

    public Teacher(Integer id, String name, String sex, String age, String workId, Integer counts) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.workId = workId;
        this.counts = counts;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

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

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", workId='" + workId + '\'' +
                ", counts=" + counts +
                '}';
    }
}
