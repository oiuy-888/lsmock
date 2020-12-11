package com.example.lsmock.controller;

import com.example.lsmock.dao.Sql;
import com.example.lsmock.datasource.JdbcConn;
import com.example.lsmock.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/back-end/sql")
public class SqlController {

    @Autowired
    private JdbcConn jdbcConn;

    @RequestMapping(value="bases", method = RequestMethod.POST)
    public Result getbases(HttpServletRequest request,@RequestBody Sql sql) {
        try {
            request.setCharacterEncoding("UTF-8");
            ArrayList<String> list = jdbcConn.sqlConn(sql);
            return new Result(Result.Success,Result.SuccessMsg,list);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

}
