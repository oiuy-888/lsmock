package com.example.lsmock.dao;

import lombok.Data;

@Data
public class Sql {

    private Integer id;
    private String ip;
    private String port;
    private String name;
    private String password;
    private String bases;
    private String sql;
    private String index;

}
