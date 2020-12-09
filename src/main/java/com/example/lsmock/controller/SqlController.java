package com.example.lsmock.controller;

import com.example.lsmock.dao.Sql;
import com.example.lsmock.dao.User;
import com.example.lsmock.dao.UserInfo;
import com.example.lsmock.datasource.JdbcConn;
import com.example.lsmock.service.UserInfoService;
import com.example.lsmock.service.UserService;
import com.example.lsmock.utils.Auth;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value="/back-end/sql")
public class SqlController {

    @Autowired
    private JdbcConn jdbcConn;

    @RequestMapping(value="bases", method = RequestMethod.GET)
    public Result getbases(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        jdbcConn.sqlConn();
        return new Result(Result.Success,Result.SuccessMsg);
    }

}
