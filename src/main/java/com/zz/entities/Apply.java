package com.zz.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("apply")
public class Apply {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userId;
    private String zxjId;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date applyTime;
    private String applyTiaojian;
    private String img;
    private String teaWorkId;
    @TableField(exist = false)
    private Integer counts;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getZxjId() {
        return zxjId;
    }

    public void setZxjId(String zxjId) {
        this.zxjId = zxjId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyTiaojian() {
        return applyTiaojian;
    }

    public void setApplyTiaojian(String applyTiaojian) {
        this.applyTiaojian = applyTiaojian;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTeaWorkId() {
        return teaWorkId;
    }

    public void setTeaWorkId(String teaWorkId) {
        this.teaWorkId = teaWorkId;
    }
}
