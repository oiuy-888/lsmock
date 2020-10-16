package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.User;
import com.example.lsmock.dao.UserInfo;
import com.example.lsmock.interceptor.LoginInterceptor;
import com.example.lsmock.service.UserInfoService;
import com.example.lsmock.service.UserService;
import com.example.lsmock.utils.Auth;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value="/back-end/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoginInterceptor loginInterceptor;

    @RequestMapping(value="info", method = RequestMethod.GET)
    public Result finduserinfo(HttpServletRequest request, @RequestParam("userid") String userid) throws IOException {
        request.setCharacterEncoding("UTF-8");
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(Integer.valueOf(userid));
        JSONObject json = new JSONObject();
        return new Result(Result.Success,Result.SuccessMsg,userInfoService.findByUserId(userinfo));

    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public Result addhost(HttpServletRequest request, @RequestBody User user) throws IOException {
        request.setCharacterEncoding("UTF-8");
        User resultuser = userService.findByName(user);
        resultuser.setToken(Auth.token(user.getUsername(),user.getPassword()));
        resultuser.setPassword(null);//频闭返回密码值
        if((userService.findByName(user).getPassword()).equals(user.getPassword())){
            return new Result(Result.Success,Result.SuccessMsg,resultuser);
        }else {
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

}
