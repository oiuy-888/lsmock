package com.example.lsmock.service;

import com.example.lsmock.dao.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public String findByName(User user);
    public String token (String username,String password);
    public boolean verify(String token);
}
