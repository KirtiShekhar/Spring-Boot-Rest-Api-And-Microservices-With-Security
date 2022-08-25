package com.springboot.restapisample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SpringBoot RestApi Sample", version = "2.0", description = "Spring Boot Application with Rest API Concepts"))
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
        System.out.println( "Running Application Spring Boot Rest API!" );
    }
}
