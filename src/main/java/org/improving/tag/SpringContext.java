package org.improving.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration///i am here to configure spring
@ComponentScan("org.improving.tag")//i want Spring to scan this package, find all classes that has "@Component" in it and memorize them

public class SpringContext {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tag?serverTimezone = UTC");
        dataSource.setUsername("zachlocal");
        dataSource.setPassword("Buggywhip22");
        return dataSource;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}