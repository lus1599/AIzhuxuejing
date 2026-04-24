package com.zz.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("zxj")
public class Zxj {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String zxjName;
    private String zxjMoney;
    private String zxjTiaojian;
    private String workId;
    @TableField(exist = false)
    private Integer counts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZxjName() {
        return zxjName;
    }

    public void setZxjName(String zxjName) {
        this.zxjName = zxjName;
    }

    public String getZxjMoney() {
        return zxjMoney;
    }

    public void setZxjMoney(String zxjMoney) {
        this.zxjMoney = zxjMoney;
    }

    public String getZxjTiaojian() {
        return zxjTiaojian;
    }

    public void setZxjTiaojian(String zxjTiaojian) {
        this.zxjTiaojian = zxjTiaojian;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }
}
