package com.springboot.restapisample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.restapisample"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
public class AppTest 
{
    public static void main(String[] args) {
        SpringApplication.run(AppTest.class,args);
    }
}
