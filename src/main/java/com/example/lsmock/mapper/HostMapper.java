package com.example.lsmock.mapper;

import com.example.lsmock.dao.Host;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HostMapper {

    public List<Host> findAll();
    public void addHost(Host host);
    public void updateHost(Host host);
    public void deleteHost(int id);
    public Host findHost(int id);
}
