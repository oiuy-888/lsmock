package com.example.lsmock.service;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findByName(User user);
    public JSONObject token (String username, String password);
    public boolean verify(String token);
}
