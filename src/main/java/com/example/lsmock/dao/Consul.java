package com.example.lsmock.dao;

import lombok.Data;

@Data
public class Consul {

    private Integer id;
    private String uid;
    private String name;
    private String method;
    private String value;
    private String interval;
    private String timeout;
    private Integer is_delete;

}
