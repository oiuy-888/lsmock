package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.User;
import com.example.lsmock.dao.UserInfo;
import com.example.lsmock.service.UserInfoService;
import com.example.lsmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String addhost(HttpServletRequest request, @RequestBody User user) throws IOException {
        request.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();
        if((userService.findByName(user).getPassword()).equals(user.getPassword())){
            json.put("code",20000);
            json.put("id",userService.findByName(user).getId());
            json.put("data",userService.token(user.getUsername(),user.getPassword()));
        }else {
            json.put("code",60204);
            json.put("message","密码错误");
        }
        return json.toString();
    }

    @RequestMapping(value="info", method = RequestMethod.GET)
    public String finduserinfo(HttpServletRequest request, @RequestParam("userid") String userid) throws IOException {
        request.setCharacterEncoding("UTF-8");
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(Integer.valueOf(userid));
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data",userInfoService.findByUserId(userinfo));
        return json.toString();
    }

}
