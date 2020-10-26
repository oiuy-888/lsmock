package com.example.lsmock.service;

import com.example.lsmock.dao.Host;

import java.util.List;

public interface HostService {

    public List<Host> findAll();
    public void addHost(Host host);
    public void updateHost(Host host);
    public void deleteHost(int id);
    public Host findHost(int id);
}
