package com.car.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.car.admin.mapper")
public class DemoRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestfulApplication.class, args);
    }

}
