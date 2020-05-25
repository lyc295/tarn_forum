package com.tarn.tarn_forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.tarn.tarn_forum.*"})
@MapperScan(value = "com.tarn.tarn_forum.*")
@EnableCaching
@EnableScheduling
public class TarnForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarnForumApplication.class, args);
    }

}
