package com.zz.entities.model;

public class ResetPwd {
    private String oldpwd;
    private String newpwd;

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public ResetPwd() {
    }

    public ResetPwd(String oldpwd, String newpwd) {
        this.oldpwd = oldpwd;
        this.newpwd = newpwd;
    }

    @Override
    public String toString() {
        return "ResetPwd{" +
                "oldpwd='" + oldpwd + '\'' +
                ", newpwd='" + newpwd + '\'' +
                '}';
    }
}
