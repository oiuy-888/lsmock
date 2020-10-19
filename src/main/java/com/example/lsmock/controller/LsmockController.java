package com.example.lsmock.controller;

import com.example.lsmock.dao.Lsmock;
import com.example.lsmock.service.LsmockService;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/back-end/lsmock")
public class LsmockController {

    @Autowired
    private LsmockService lsmockService;

    @RequestMapping(value="addlsmock", method = RequestMethod.POST)
    public Result addlsmock(HttpServletRequest request, @RequestBody Lsmock lsmock) {
        try{
            request.setCharacterEncoding("UTF-8");
            lsmockService.addLsmock(lsmock);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value = "updatelsmock", method = RequestMethod.POST)
    public Result updatelsmock(HttpServletRequest request, @RequestBody Lsmock lsmock) {
        try {
            request.setCharacterEncoding("UTF-8");
            lsmockService.updateLsmock(lsmock);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="findlsmock", method = RequestMethod.GET)
    public Result findlsmock(HttpServletRequest request) throws IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            List<Lsmock> list = lsmockService.findAll();
            return new Result(Result.Success,Result.SuccessMsg,list);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="selelsmock", method = RequestMethod.GET)
    public Result selelsmock(HttpServletRequest request, @RequestParam("id") Integer id) {
        try{
            request.setCharacterEncoding("UTF-8");
            Lsmock lsmock = lsmockService.findLsmock(id);
            return new Result(Result.Success,Result.SuccessMsg,lsmock);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="deletelsmock", method = RequestMethod.GET)
    public Result deletelsmock(HttpServletRequest request, @RequestParam("id") Integer id) {
        try{
            request.setCharacterEncoding("UTF-8");
            lsmockService.deleteLsmock(id);
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

}
