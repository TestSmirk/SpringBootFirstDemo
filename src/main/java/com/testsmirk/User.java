package com.testsmirk;

import com.testsmirk.model.ErrorModel;

public class User  {
    private String username;
    private Integer age;
    private String password;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    // 省略getter和setter
}