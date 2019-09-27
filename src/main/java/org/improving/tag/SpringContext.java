package org.improving.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration///i am here to configure spring
@ComponentScan("org.improving.tag")//i want Spring to scan this package, find all classes that has "@Component" in it and memorize them
public class SpringContext {
    @Bean
    public Scanner getScanner() {return new Scanner(System.in);}
    }