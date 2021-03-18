package com.example.lsmock.dao;

import lombok.Data;

@Data
public class FormSql {

    private Integer id;
    private String form;
    private String sql;
    private String version;
    private Integer is_delete;

}
