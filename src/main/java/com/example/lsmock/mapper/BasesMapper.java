package com.example.lsmock.mapper;

import com.example.lsmock.dao.Bases;
import com.example.lsmock.dao.Bases_FormSql;
import com.example.lsmock.dao.Consul;
import com.example.lsmock.dao.FormSql;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BasesMapper {

    //数据库
    public List<Bases> findAll();
    public Bases findBases(Bases bases);
    public Integer addBases(Bases bases);
    public void deleteBases(Bases bases);

    //表
    public Integer addForm(FormSql formSql);
    public FormSql findFormsql(FormSql formSql);
    public Integer addBases_Form(Bases_FormSql bases_formSql);
    public void deleteForm(FormSql formSql);

}
