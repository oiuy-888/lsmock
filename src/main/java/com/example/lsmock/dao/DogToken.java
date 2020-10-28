package com.example.lsmock.dao;

public class DogToken {

    private Integer id;
    private String accessToken;
    private String aspid;
    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAspid() {
        return aspid;
    }

    public void setAspid(String aspid) {
        this.aspid = aspid;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }
}
