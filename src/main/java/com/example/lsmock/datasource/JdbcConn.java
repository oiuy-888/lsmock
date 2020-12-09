package com.example.lsmock.datasource;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class JdbcConn {

    public void sqlConn() throws Exception{
        String URL="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("show databases");

        while (rs.next()){
            System.out.println(rs.getString(1));
        }
        rs.close();
        st.close();
        conn.close();
    }

}
