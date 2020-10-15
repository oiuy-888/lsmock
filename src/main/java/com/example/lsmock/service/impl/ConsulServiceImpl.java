package com.example.lsmock.service.impl;

import com.example.lsmock.dao.Consul;
import com.example.lsmock.mapper.ConsulMapper;
import com.example.lsmock.service.ConsulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsulServiceImpl implements ConsulService {

    @Autowired
    private ConsulMapper consulMapper;

    @Override
    public  List<Consul> findAll() {
        return consulMapper.findAll();
    }

}
