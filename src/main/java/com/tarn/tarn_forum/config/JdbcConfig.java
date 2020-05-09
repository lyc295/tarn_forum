package com.tarn.tarn_forum.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class JdbcConfig {
    @Value("${spring.datasource.url}")
    public String url;
    @Value("${spring.datasource.driver-class-name}")
    public String driverClassName;
    @Value("${spring.datasource.username}")
    public String userName;
    @Value("${spring.datasource.password}")
    public String userPwd;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(userPwd);
        return dataSource;
    }
}
