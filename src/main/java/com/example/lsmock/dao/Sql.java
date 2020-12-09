package com.example.lsmock.dao;

public class Sql {

    private Integer id;
    private String name;
    private String password;
    private String bases;
    private String sql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
