package com.zz.entities.view;

public class LoginView {
    private String role;
    private String nickname;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LoginView() {
    }

    public LoginView(String role, String nickname) {
        this.role = role;
        this.nickname = nickname;
    }
}
