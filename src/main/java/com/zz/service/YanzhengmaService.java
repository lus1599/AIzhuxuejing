package com.zz.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.UUID;
import com.zz.entities.Yanzhengma;
import com.zz.mapper.YanzhengmaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class YanzhengmaService {
    @Autowired
    private YanzhengmaMapper yanzhengmaMapper;


    //检查验证码
//    public boolean check(Yanzhengma yanzhengma) {
//        Yanzhengma y = yanzhengmaMapper.selectById(yanzhengma.getUuid());
//        System.out.println(yanzhengma.getCode());
//        return y == null ? false :
//                y.getUuid().equals(yanzhengma.getCode());
//    }

    // 检查验证码正确写法
//    public boolean check(Yanzhengma yanzhengma) {
//        // 从数据库中根据 UUID 查询验证码记录
//        Yanzhengma y = yanzhengmaMapper.selectById(yanzhengma.getUuid());
//        boolean equals = y.getCode().equals(yanzhengma.getCode());
//       // System.out.println("sql code:" + y.getCode() + " code:" + yanzhengma.getCode() + " equals:" + equals);
//        // 如果查询结果为 null，返回 false；否则比较存储的验证码与用户输入的验证码
//        return y == null ? false : equals;
//    }


    //创建验证码
    public HashMap<String, String> create() {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //输出code
        String code = lineCaptcha.getCode();
        //生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = UUID.randomUUID().toString();
        String imageBase64 = lineCaptcha.getImageBase64();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uuid", uuid);
        hashMap.put("code", code);
        hashMap.put("base64", "data:image/png;base64," + imageBase64);

        //存到数据库
        yanzhengmaMapper.insert(new Yanzhengma(uuid, code));
        return hashMap;
    }
}
