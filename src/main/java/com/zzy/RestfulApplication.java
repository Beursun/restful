package com.zzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzy.dao")
public class RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
        System.out.println("开始执行...");
    }

}
