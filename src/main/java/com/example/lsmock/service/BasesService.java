package com.example.lsmock.service;

import com.example.lsmock.dao.Bases;
import com.example.lsmock.dao.Bases_FormSql;
import com.example.lsmock.dao.FormSql;

import java.util.List;

public interface BasesService {

    public List<Bases> findAll();
    public Bases findBases(Bases bases);
    public Integer addBases(Bases bases);
    public void deleteBases(Bases bases);

    public Integer addForm(FormSql formSql);
    public FormSql findFormsql(FormSql formSql);
    public Integer addBases_Form(Bases_FormSql bases_formSql);

}
