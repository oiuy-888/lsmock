package com.example.lsmock.interceptor;

import com.example.lsmock.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //过滤器（filter）和拦截器（interceptor）  过滤前-拦截前-action执行-拦截后-过滤后

    @Autowired
    private UserServiceImpl userService;
    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {
        //不过滤的url处理
        String uri = httpServletRequest.getRequestURI();
        for (String url : excludedUrls) {
            if (uri.contains(url)) {
                return true;
            }
        }
        //需要处理的url
        String header = httpServletRequest.getHeader("X-token");
        if(userService.verify(header)){
            return true;
        }

        return false;
    }



}
