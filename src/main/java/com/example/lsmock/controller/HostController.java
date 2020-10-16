package com.example.lsmock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.Host;
import com.example.lsmock.service.HostService;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value="/back-end/host")
public class HostController {

    @Autowired
    private HostService hostService;


    @RequestMapping(value="findhost", method = RequestMethod.GET)
    public Result findhost(HttpServletRequest request) {
        try{
            request.setCharacterEncoding("utf-8");
            List<Host> list = hostService.findAll();
            return new Result(Result.Success,Result.SuccessMsg,list);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    
    @RequestMapping(value="updatehost", method = RequestMethod.POST)
    public Result updatehost(HttpServletRequest request, @RequestBody List<Host> host) {
        try{
            request.setCharacterEncoding("UTF-8");
            List<Integer> list = hostService.findHostId();
            List<Integer> dellist = hostService.findHostId();
            for(int i=0;i<host.size();i++) {
                if (list.contains(host.get(i).getId())) {
                    hostService.updateHost(host.get(i));
                    dellist.remove(host.get(i).getId());
                }if(!list.contains(host.get(i).getId())){
                    hostService.addHost(host.get(i));
                }
            }
            for (int i=0;i<dellist.size();i++){
                hostService.deleteHost(dellist.get(i));
            }
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="addhost", method = RequestMethod.POST)
    public Result addhost(HttpServletRequest request, @RequestBody List<Host> host) throws IOException {
        request.setCharacterEncoding("UTF-8");
        for (int i=0;i<host.size();i++){
            hostService.addHost(host.get(i));
        }
        return new Result(Result.Success,Result.SuccessMsg);
    }

    @RequestMapping(value="deletehost", method = RequestMethod.GET)
    public Result deletehost(HttpServletRequest request, @RequestParam("id") Integer id) throws IOException {
        request.setCharacterEncoding("UTF-8");
        hostService.deleteHost(id);
        JSONObject json = new JSONObject();
        return new Result(Result.Success,Result.SuccessMsg);
    }
}
