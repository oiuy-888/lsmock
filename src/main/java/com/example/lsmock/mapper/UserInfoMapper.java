package com.example.lsmock.mapper;

import com.example.lsmock.dao.User;
import com.example.lsmock.dao.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserInfoMapper {

    public UserInfo findByUserId(UserInfo userInfo);
}
