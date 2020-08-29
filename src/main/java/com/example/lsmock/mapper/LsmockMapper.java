package com.example.lsmock.mapper;

import com.example.lsmock.dao.Lsmock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LsmockMapper {

    public List<Lsmock> findAll();
    public void addLsmock(Lsmock lsmock);
    public void updateLsmock(Lsmock lsmock);
    public void deleteLsmock(int id);
}
