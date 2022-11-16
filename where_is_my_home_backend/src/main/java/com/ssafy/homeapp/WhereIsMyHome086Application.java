package com.ssafy.homeapp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.ssafy.homeapp.model.dao", annotationClass = Mapper.class)
@SpringBootApplication
public class WhereIsMyHome086Application {

	public static void main(String[] args) {
		SpringApplication.run(WhereIsMyHome086Application.class, args);
	}

}
