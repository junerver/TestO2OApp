package com.junerver.testo2oapp.model;

/**
 * Created by junerver on 2015/11/29.
 */
public class User {
    private String nick_name;
    private String user_name;
    private String user_pass;
    private String telephone;
    private String address;
    private String avatar;
    private char u_or_b_flag;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public char getU_or_b_flag() {
        return u_or_b_flag;
    }

    public void setU_or_b_flag(char u_or_b_flag) {
        this.u_or_b_flag = u_or_b_flag;
    }
}
