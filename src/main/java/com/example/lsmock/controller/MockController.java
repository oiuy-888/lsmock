package com.example.lsmock.controller;

import com.example.lsmock.dao.Lsmock;
import com.example.lsmock.service.LsmockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/mock")
public class MockController {

    @Autowired
    private LsmockService lsmockService;

    @RequestMapping(value="**", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, @RequestBody String parm) throws IOException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        List<Lsmock> list = lsmockService.findAll();
        int i,size = list.size();
        String res = request.getServletPath().replace("/mock","");//返回除去host和工程名部分的路径
        String rep = "No matching";
        for (Lsmock ls:list){
            if(res.equals(ls.getUrl())){
                if(parm.contains(ls.getKeyword())){
                    Thread.sleep(Integer.valueOf(ls.getTime())*1000);
                    rep=ls.getRespond();
                }
            }
        }
        return rep;
    }

    @RequestMapping(value="**", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request) throws IOException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        List<Lsmock> list = lsmockService.findAll();
        int i,size = list.size();
        String res = request.getServletPath().replace("/mock","");
        String parm = request.getQueryString();// 得到请求的URL地址中附带的参数
        String rep = "No matching";
        for (Lsmock ls:list){
            if(res.equals(ls.getUrl())){
                if(parm.contains(ls.getKeyword())){
                    Thread.sleep(Integer.valueOf(ls.getTime())*1000);
                    rep=ls.getRespond();
                }
            }
        }
        return rep;
    }

}
