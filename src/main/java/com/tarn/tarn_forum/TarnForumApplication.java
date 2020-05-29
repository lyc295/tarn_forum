package com.tarn.tarn_forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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
public class TarnForumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TarnForumApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TarnForumApplication.class);
    }

}
