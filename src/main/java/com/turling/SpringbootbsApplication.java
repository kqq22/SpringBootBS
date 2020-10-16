package com.turling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.turling.dao")
public class SpringbootbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbsApplication.class, args);
    }

}
