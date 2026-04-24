package com.zz.utils;


public class CheckParam {
    //校验密码格式
    public static boolean checkPwd(String pwd) {
        String pwdPattern = "^[a-zA-Z0-9]{5,10}$";
        return pwd.matches(pwdPattern);
    }
}
