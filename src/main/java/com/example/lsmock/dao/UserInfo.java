package com.example.lsmock.dao;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

    private Integer userId;
    private String name;
    private String avatar;
    //默认赋值admin权限
    private static List<String> roles = new ArrayList<String>(){{add("admin");}};

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
