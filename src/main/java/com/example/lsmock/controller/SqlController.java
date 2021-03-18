package com.example.lsmock.controller;

import com.example.lsmock.dao.Bases;
import com.example.lsmock.dao.Bases_FormSql;
import com.example.lsmock.dao.FormSql;
import com.example.lsmock.bean.Sql;
import com.example.lsmock.datasource.JdbcConn;
import com.example.lsmock.service.BasesService;
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
    @Autowired
    private BasesService basesService;

    private static Integer base_id;
    private static Integer form_id;

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

    @RequestMapping(value="basesnew", method = RequestMethod.POST)
    public Result getbasesnew(HttpServletRequest request,@RequestBody Sql sql) {
        try {
            request.setCharacterEncoding("UTF-8");
            ArrayList<Object> list = jdbcConn.sqlConnNew(sql);
            return new Result(Result.Success,Result.SuccessMsg,list);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value = "addbases", method = RequestMethod.POST)
    public Result addbases(HttpServletRequest request, @RequestBody Bases bases) {
        try {
            request.setCharacterEncoding("UTF-8");
            if(basesService.findBases(bases)!=null){
                base_id = basesService.findBases(bases).getId();
            }else{
                base_id = basesService.addBases(bases);
            }
            return new Result(Result.Success,Result.SuccessMsg,base_id);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

    @RequestMapping(value = "addformsql", method = RequestMethod.POST)
    public Result addformsql(HttpServletRequest request, @RequestBody FormSql formSql) {
        try {
            request.setCharacterEncoding("UTF-8");
            if(basesService.findFormsql(formSql)!=null){
                return new Result(Result.Error,Result.ExitMsg);
            }else{
                form_id = basesService.addForm(formSql);
                Bases_FormSql basesFormSql = new Bases_FormSql();
                basesFormSql.setBaseId(base_id);
                basesFormSql.setFormsqlId(form_id);
                basesService.addBases_Form(basesFormSql);
            }
            return new Result(Result.Success,Result.SuccessMsg,form_id);
        }catch (Exception e){
            return new Result(Result.Error,Result.ErrorMsg);
        }
    }

}
