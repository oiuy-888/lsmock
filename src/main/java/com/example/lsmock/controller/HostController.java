package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.Host;
import com.example.lsmock.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value="/host")
public class HostController {

    @Autowired
    private HostService hostService;


    @RequestMapping(value="findhost", method = RequestMethod.GET)
    public String findhost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        List<Host> list = hostService.findAll();
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data",list);
        return json.toString();
    }

    @RequestMapping(value="addhost", method = RequestMethod.POST)
    public String addhost(HttpServletRequest request, HttpServletResponse response, @RequestBody Host host) throws IOException {
        request.setCharacterEncoding("UTF-8");
//        System.out.println("请求头start");
//        System.out.println(request.getHeader("Content-Type"));
//        System.out.println("请求头end");
        hostService.addHost(host);
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data","添加成功");
        return json.toString();
    }
}
