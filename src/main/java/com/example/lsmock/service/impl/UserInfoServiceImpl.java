package com.example.lsmock.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.lsmock.dao.User;
import com.example.lsmock.dao.UserInfo;
import com.example.lsmock.mapper.UserInfoMapper;
import com.example.lsmock.mapper.UserMapper;
import com.example.lsmock.service.UserInfoService;
import com.example.lsmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo findByUserId(UserInfo userInfo) {
        return userInfoMapper.findByUserId(userInfo);
    }
}
