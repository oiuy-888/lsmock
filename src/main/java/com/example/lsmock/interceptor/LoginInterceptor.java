package com.example.lsmock.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.utils.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    //过滤器（filter）和拦截器（interceptor）  过滤前-拦截前-action执行-拦截后-过滤后

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //不过滤的url处理
        String uri = httpServletRequest.getRequestURI();
        for (String url : excludedUrls) {
            if (uri.contains(url)) {
                return true;
            }
        }
        //需要处理的url
        String header = httpServletRequest.getHeader("X-token");
        if(Auth.verify(header)){
            return true;
        }else{
            log.info("X-token失效");
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            JSONObject json = new JSONObject();
            json.put("code",50000);
            json.put("message","请重新登录");
            httpServletResponse.getWriter().print(json);
            return false;
        }
    }



}
