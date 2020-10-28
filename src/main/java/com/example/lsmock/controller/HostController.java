package com.example.lsmock.controller;

import com.example.lsmock.dao.Host;
import com.example.lsmock.service.HostService;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Result updatehost(HttpServletRequest request, @RequestBody Host host) {
        try{
            request.setCharacterEncoding("UTF-8");
            hostService.updateHost(host);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="addhost", method = RequestMethod.POST)
    public Result addhost(HttpServletRequest request, @RequestBody Host host) {
        try{
            request.setCharacterEncoding("UTF-8");
            hostService.addHost(host);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="deletehost", method = RequestMethod.GET)
    public Result deletehost(HttpServletRequest request, @RequestParam("id") Integer id){
        try{
            request.setCharacterEncoding("UTF-8");
            hostService.deleteHost(id);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="findHost", method = RequestMethod.GET)
    public Result findHost(HttpServletRequest request, @RequestParam("id") Integer id){
        try{
            request.setCharacterEncoding("UTF-8");
            Host host = hostService.findHost(id);
            return new Result(Result.Success,Result.SuccessMsg,host);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }
}
