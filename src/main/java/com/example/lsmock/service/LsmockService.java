package com.example.lsmock.service;

import com.example.lsmock.dao.Lsmock;

import java.util.List;

public interface LsmockService {

    public List<Lsmock> findAll();
    public void addLsmock(Lsmock lsmock);
    public void updateLsmock(Lsmock lsmock);
    public void deleteLsmock(int id);
    public Lsmock findLsmock(int id);
}
