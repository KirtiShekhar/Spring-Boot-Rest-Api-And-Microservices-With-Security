package com.springboot.bankingsecurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Banking Security", version = "2.0", description = "Spring Boot Application consisting of security concepts Named Spring Boot Banking Security"))
@EnableWebSecurity(debug = true)
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
        System.out.println( "Running Application Spring Boot Banking Security Demonstrating Spring Security Concepts!" );
    }
}