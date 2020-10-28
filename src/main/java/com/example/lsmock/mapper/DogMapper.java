package com.example.lsmock.mapper;

import com.example.lsmock.dao.DogCfg;
import com.example.lsmock.dao.DogToken;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DogMapper {

    public void addDogToken(DogToken dogToken);
    public void updateDogToken();
    public void deleteDogToken();
    public DogToken findDogToken();
    public DogCfg findDogCfg();

}
