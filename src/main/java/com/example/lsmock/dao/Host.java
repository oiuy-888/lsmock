package com.example.lsmock.dao;

public class Host {

    private Integer id;
    private String host;
    private String name;
    private String createuser;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateruser() {
        return createuser;
    }

    public void setCreateruser(String createruser) {
        this.createuser = createruser;
    }
}
