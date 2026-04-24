package com.zz;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.Guanliyuan;
import com.zz.mapper.GuanliyuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

//初始化管理员数据
@Component
public class CreateAdmin implements CommandLineRunner {
    @Autowired
    private GuanliyuanMapper guanliyuanMapper;
//管理员始终密码号
    private static final String username = "admin";
    private static final String password = "admin";

    @Override
    public void run(String... args) throws Exception {
        Guanliyuan admin = guanliyuanMapper.selectOne(new QueryWrapper<Guanliyuan>().eq("username", username));
        if (admin != null) {
            System.out.println("管理员已存在：" + username);
            return;
        }
        //创建随机数
        Random random = new Random();
        int a = random.nextInt();
        //将随机数加密
        String salt = SecureUtil.md5(String.valueOf(a));
        //将加密的密码和加密的随机数作为存入的数据库的密码
        String dbpassword = SecureUtil.md5(password + salt);

        guanliyuanMapper.insert(new Guanliyuan(null, username, dbpassword, salt));
        System.out.println("已创建管理员：" + username + "\n密码：" + password);
    }
}
