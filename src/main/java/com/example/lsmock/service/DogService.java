package com.example.lsmock.service;

import com.example.lsmock.dao.DogCfg;
import com.example.lsmock.dao.DogToken;

import java.util.List;

public interface DogService {

    public String accessToken() throws Exception;
    public String sendMessage(String title, String content, String url, List<String> pins) throws Exception;

    public void addDogToken() throws Exception;
    public void updateDogToken();
    public void deleteDogToken();
    public DogToken findDogToken();
    public DogCfg findDogCfg();
}
