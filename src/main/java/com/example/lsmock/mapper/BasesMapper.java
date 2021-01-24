package com.example.lsmock.mapper;

import com.example.lsmock.dao.Bases;
import com.example.lsmock.dao.Consul;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BasesMapper {

    public List<Bases> findAll();
    public Bases findBases(Bases bases);
    public Integer addBases(Bases bases);
    public void deleteBases(Bases bases);
}
