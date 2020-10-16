package com.example.lsmock.controller;

import com.example.lsmock.dao.Consul;
import com.example.lsmock.service.ConsulService;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/back-end/consul")
public class ConsulController {

    @Autowired
    private ConsulService consulService;


    @RequestMapping(value="findconsul", method = RequestMethod.GET)
    public Result findconsul(HttpServletRequest request) {
        try{
            request.setCharacterEncoding("utf-8");
            List<Consul> list = consulService.findAll();
            return new Result(Result.Success,Result.SuccessMsg,list);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

}
