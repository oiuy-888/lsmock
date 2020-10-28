package com.example.lsmock.dao;

import java.util.List;

public class DogMsg {

    private Integer id;
    private String title;
    private String content;
    private String url;
    private List<String> pins;
    private String aspid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPins() {
        return pins;
    }

    public void setPins(List<String> pins) {
        this.pins = pins;
    }

    public String getAspid() {
        return aspid;
    }

    public void setAspid(String aspid) {
        this.aspid = aspid;
    }
}
