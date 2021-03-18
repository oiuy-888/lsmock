package com.example.lsmock.datasource;

import com.example.lsmock.bean.DataSql;
import com.example.lsmock.bean.Sql;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class JdbcConn {


    //基础库、表查询
    public ArrayList<String> sqlConn(Sql sql) throws Exception{
        String URL="jdbc:mysql://"+sql.getIp()+":"+sql.getPort()+"/"+sql.getBases()+"?characterEncoding=UTF-8&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, sql.getName(), sql.getPassword());
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql.getSql());
        ArrayList<String> list = new ArrayList<String>();
        while (rs.next()){
            if(sql.getIndex()==null|| sql.getIndex() == ""){
                list.add(rs.getString(rs.getMetaData().getColumnCount()));   //取最后一列内容
            }else{
                list.add(rs.getString(Integer.valueOf(sql.getIndex())));
            }
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    //指定表、建表语句,rs.getMetaData().getColumnCount()获取列长度
    public ArrayList<Object> sqlConnNew(Sql sql) throws Exception{
        String URL="jdbc:mysql://"+sql.getIp()+":"+sql.getPort()+"/"+sql.getBases()+"?characterEncoding=UTF-8&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, sql.getName(), sql.getPassword());
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql.getSql());
        ArrayList<Object> list = new ArrayList<Object>();
        DataSql dataSql = new DataSql();
        while (rs.next()){
            dataSql.setDataform(rs.getString(1));
            dataSql.setDatasql(rs.getString(2));
            list.add(dataSql);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

}
