package com.example.lsmock.controller;

import com.example.lsmock.dao.Lsmock;
import com.example.lsmock.service.LsmockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
public class LsmockController {

    @Autowired
    private LsmockService lsmockService;

    /**
     * 获得post请求body中附带的参数内容
     * @param request
     * @return String
     * @throws IOException
     */
    public String readbody(HttpServletRequest request) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line= reader.readLine()) != null){
            jb.append(line);
        }
        reader.close();
        return jb.toString();
    }

    /**
     * 处理全部POST请求
     * @param request
     * @param response
     * @return String
     * @throws IOException
     * @throws ServletException
     * @throws InterruptedException
     */
    @RequestMapping(value="**", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        List<Lsmock> list = lsmockService.findAll();
        int i,size = list.size();
//        String method = request.getMethod(); //得到请求URL地址时使用的方法
        String res = request.getServletPath();//返回除去host和工程名部分的路径
        String parm = readbody(request);
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

    /**
     * 处理全部GET请求
     * @param request
     * @param response
     * @return String
     * @throws IOException
     * @throws ServletException
     * @throws InterruptedException
     */
    @RequestMapping(value="**", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InterruptedException {
        request.setCharacterEncoding("utf-8");
        List<Lsmock> list = lsmockService.findAll();
        int i,size = list.size();
//        String method = request.getMethod(); //得到请求URL地址时使用的方法
        String res = request.getServletPath();//返回除去host和工程名部分的路径
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
