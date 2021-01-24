package com.example.lsmock.service;

import com.example.lsmock.dao.Bases;

import java.util.List;

public interface BasesService {

    public List<Bases> findAll();
    public Bases findBases(Bases bases);
    public Integer addBases(Bases bases);
    public void deleteBases(Bases bases);
}
