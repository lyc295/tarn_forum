package com.tarn.tarn_forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.tarn.tarn_forum.*"})
@MapperScan(value = "com.tarn.tarn_forum.*")
public class TarnForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarnForumApplication.class, args);
    }

}
