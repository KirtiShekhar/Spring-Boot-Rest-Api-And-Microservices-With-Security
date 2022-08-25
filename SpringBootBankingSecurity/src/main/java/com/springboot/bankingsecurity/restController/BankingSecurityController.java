package com.springboot.bankingsecurity.restController;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankingSecurity")
public class BankingSecurityController
{
    Logger bankingSecurityLogger = LoggerFactory.getLogger(BankingSecurityController.class);

    @Autowired
    Environment environment;

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        bankingSecurityLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        bankingSecurityLogger.info("Running Application Spring Boot Banking Security Demonstrating Spring Security Concepts running on port : "+ port);
        return "Running Application Spring Boot Banking Security Demonstrating Spring Security Concepts running on port : "+ port;
    }
}