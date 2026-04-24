package com.zz.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("score")
public class Score {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String collegeName;
    private String stuName;
    private String stuNumber;
    private String scoreDe;
    private String scoreZhi;
    private String scoreTi;
    private String scoreNeng;
    private String scoreCount;
    private String scoreAvg;
    /**
     * 学期
     */
    private String xueqi;
    @TableField(exist = false)
    private Integer counts;


    public String getXueqi() {
        return xueqi;
    }

    public void setXueqi(String xueqi) {
        this.xueqi = xueqi;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(String scoreAvg) {
        this.scoreAvg = scoreAvg;
    }

    public String getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(String scoreCount) {
        this.scoreCount = scoreCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getScoreDe() {
        return scoreDe;
    }

    public void setScoreDe(String scoreDe) {
        this.scoreDe = scoreDe;
    }

    public String getScoreZhi() {
        return scoreZhi;
    }

    public void setScoreZhi(String scoreZhi) {
        this.scoreZhi = scoreZhi;
    }

    public String getScoreTi() {
        return scoreTi;
    }

    public void setScoreTi(String scoreTi) {
        this.scoreTi = scoreTi;
    }

    public String getScoreNeng() {
        return scoreNeng;
    }

    public void setScoreNeng(String scoreNeng) {
        this.scoreNeng = scoreNeng;
    }
}
