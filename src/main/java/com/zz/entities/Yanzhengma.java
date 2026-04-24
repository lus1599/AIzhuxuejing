package com.zz.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("yanzhengma")
public class Yanzhengma {
    @TableId(value = "uuid")

    private String uuid;
    private String code;

    public String getUuid() {

        return uuid;
    }

    public void setUuid(String uuid) {

        this.uuid = uuid;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public Yanzhengma() {

    }

    public Yanzhengma(String uuid, String code) {
        this.uuid = uuid;
        this.code = code;
    }
}
