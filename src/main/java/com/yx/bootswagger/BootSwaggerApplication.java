package com.yx.bootswagger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yx.bootswagger.shiro.mapper"})
public class BootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSwaggerApplication.class, args);
    }

}
