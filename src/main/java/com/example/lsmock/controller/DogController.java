package com.example.lsmock.controller;

import com.example.lsmock.dao.DogMsg;
import com.example.lsmock.service.DogService;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/back-end/dog")
public class DogController {

    @Autowired
    private DogService dogService;
    
    @RequestMapping(value="addtoken", method = RequestMethod.GET)
    public Result adddogtoken(HttpServletRequest request) {
        try{
            request.setCharacterEncoding("utf-8");
            dogService.addDogToken();
            return new Result(Result.Success,Result.SuccessMsg);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value="sendmsg", method = RequestMethod.POST)
    public Result sendmsg(HttpServletRequest request, @RequestBody DogMsg dogMsg) {
        try{
            request.setCharacterEncoding("UTF-8");
            String result = dogService.sendMessage(dogMsg.getTitle(),dogMsg.getContent(),dogMsg.getUrl(),dogMsg.getPins());//加鉴权
            return new Result(Result.Success,Result.SuccessMsg,result);
        }catch(Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }
}
