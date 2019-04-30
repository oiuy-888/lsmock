package com.example.lsmock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.lsmock.mapper")
public class LsmockApplication {
	public static void main(String[] args) {
		SpringApplication.run(LsmockApplication.class, args);
	}
}
