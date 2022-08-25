package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.CustomerRequestDto;
import com.springboot.bankingsecurity.entity.Authority;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController
{
    Logger customersLogger = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers/customerLogin")
    public Customer saveCustomer(Principal customer)
    {
        Customer savedCustomer = new Customer();
        customersLogger.info("Inserting new Customer to database");
        try
        {
            customersLogger.info("invoking customerService.saveCustomerAndAuthority(customerRequestDto) service");
            savedCustomer = customerService.getUserDetailsAfterLogin(customer);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in insert Customer : " + errorMessage);
        }

        return savedCustomer;
    }
}