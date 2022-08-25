package com.springboot.microservices.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
        System.out.println( "Running Application Spring Boot Microservices Eureka Server!" );
    }
}
