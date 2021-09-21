package com.itheima.bean;

import java.io.Serializable;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 10:21
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String hobby;

    public User() {
    }

    public User(String username, String password, String hobby) {
        this.username = username;
        this.password = password;
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
