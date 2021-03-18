package com.example.lsmock.service.impl;

import com.example.lsmock.dao.Bases;
import com.example.lsmock.dao.Bases_FormSql;
import com.example.lsmock.dao.FormSql;
import com.example.lsmock.mapper.BasesMapper;
import com.example.lsmock.service.BasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasesServiceImpl implements BasesService{

    @Autowired
    BasesMapper basesMapper;

    @Override
    public List<Bases> findAll() {
        return basesMapper.findAll();
    }

    @Override
    public Bases findBases(Bases bases) {
        return basesMapper.findBases(bases);
    }

    @Override
    public Integer addBases(Bases bases) {
        basesMapper.addBases(bases);
        return bases.getId();
    }

    @Override
    public void deleteBases(Bases bases) {
        basesMapper.deleteBases(bases);
    }

    @Override
    public Integer addForm(FormSql formSql) {
        basesMapper.addForm(formSql);
        return formSql.getId();
    }

    @Override
    public FormSql findFormsql(FormSql formSql){
        return basesMapper.findFormsql(formSql);
    }

    @Override
    public Integer addBases_Form(Bases_FormSql bases_formSql) {
        basesMapper.addBases_Form(bases_formSql);
        return bases_formSql.getId();
    }

    ;
}
