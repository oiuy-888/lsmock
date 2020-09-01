package com.example.lsmock.mapper;

import com.example.lsmock.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    public List<User> findAll();
    public String findByName(User user);

}
