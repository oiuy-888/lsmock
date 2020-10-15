package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.Host;
import com.example.lsmock.dao.Lsmock;
import com.example.lsmock.service.LsmockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/lsmock")
public class LsmockController {

    @Autowired
    private LsmockService lsmockService;

    @RequestMapping(value="addlsmock", method = RequestMethod.POST)
    public String addlsmock(HttpServletRequest request, @RequestBody Lsmock lsmock) throws IOException {
        request.setCharacterEncoding("UTF-8");
        lsmockService.addLsmock(lsmock);
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data","添加成功");
        return json.toString();
    }

    @RequestMapping(value="findlsmock", method = RequestMethod.GET)
    public String findlsmock(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        List<Lsmock> list = lsmockService.findAll();
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data",list);
        return json.toString();
    }

    @RequestMapping(value="deletelsmock", method = RequestMethod.GET)
    public String deletelsmock(HttpServletRequest request, @RequestParam("id") Integer id) throws IOException {
        request.setCharacterEncoding("UTF-8");
        lsmockService.deleteLsmock(id);
        JSONObject json = new JSONObject();
        json.put("code",20000);
        json.put("data","删除成功");
        return json.toString();
    }

}
