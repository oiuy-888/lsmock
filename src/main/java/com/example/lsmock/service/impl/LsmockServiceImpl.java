package com.example.lsmock.service.impl;

import com.example.lsmock.dao.Lsmock;
import com.example.lsmock.mapper.LsmockMapper;
import com.example.lsmock.service.LsmockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LsmockServiceImpl implements LsmockService{

    @Autowired
    private LsmockMapper lsmockMapper;

    @Override
    public List<Lsmock> findAll() {
        return lsmockMapper.findAll();
    }
}
