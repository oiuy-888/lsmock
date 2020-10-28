package com.example.lsmock.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SshConn {

    @Value("${linux.host}")
    private String host;
    @Value("${linux.username}")
    private String username;
    @Value("${linux.password}")
    private String password;

    public void linuxssh() throws IOException{
        // 创建连接
        Connection conn = new Connection(host);
        // 启动连接
        conn.connect();
        // 验证用户密码
        conn.authenticateWithPassword(username, password);
        Session session = conn.openSession();
        session.execCommand("pwd");

        // 消费所有输入流
        String inStr = consumeInputStream(session.getStdout());
        String errStr = consumeInputStream(session.getStderr());
        System.out.println(inStr+"/n"+errStr);

        session.close();
        conn.close();
    }

    public static String consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s ;
        StringBuilder sb = new StringBuilder();
        while((s=br.readLine())!=null){
            System.out.println(s);
            sb.append(s);
        }
        return sb.toString();
    }
}
