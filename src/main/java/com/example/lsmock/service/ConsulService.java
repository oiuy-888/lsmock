package com.example.lsmock.service;

import com.example.lsmock.dao.Consul;

import java.util.List;

public interface ConsulService {

    public List<Consul> findAll();
    public void addConsul(Consul consul);
    public void updateConsul(Consul consul);
    public void deleteConsul(int id);
}
