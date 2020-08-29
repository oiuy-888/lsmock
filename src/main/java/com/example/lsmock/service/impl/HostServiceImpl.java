package com.example.lsmock.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.Host;
import com.example.lsmock.mapper.HostMapper;
import com.example.lsmock.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostMapper hostMapper;

    @Override
    public  List<Host> findAll() {
        return hostMapper.findAll();
    }

    @Override
    public void addHost(Host host) {
        hostMapper.addHost(host);
    }

    @Override
    public void updateHost(Host host) {
        hostMapper.updateHost(host);
    }

    @Override
    public void deleteHost(int id) {
        hostMapper.deleteHost(id);
    }

    @Override
    public List<Integer> findHostId() {
        return hostMapper.findHostId();
    }

}
