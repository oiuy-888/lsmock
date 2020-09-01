package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.User;
import com.example.lsmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String addhost(HttpServletRequest request, @RequestBody User user) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String pwd = userService.findByName(user);
        JSONObject json = new JSONObject();
        if(pwd.equals(user.getPassword())){
            json.put("code",20000);
            json.put("data",userService.token(user.getName(),user.getPassword()));
        }else {
            json.put("code",60204);
            json.put("message","密码错误");
        }
        return json.toString();
    }

}
