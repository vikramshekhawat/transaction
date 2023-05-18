package com.example.transaction;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;


@Configuration
@EnableAspectJAutoProxy
public class ProductConfig {

    @Bean
    public DataSource dataSource(){
return new DriverManagerDataSource("jdbc:mysql://localhost:3306/personal","root","root");
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}
