package com.springboot.bankingsecurity.restController;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController
{
    Logger customersLogger = LoggerFactory.getLogger(AccountsRestController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/saveCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Customer in the database")
    public Customer saveCustomerAndAuthority(@RequestBody CustomerRequestDto customerRequestDto)
    {
        Customer savedCustomer = new Customer();
        customersLogger.info("Inserting new Customer to database");
        try
        {
            customersLogger.info("invoking customerService.saveCustomerAndAuthority(customerRequestDto) service");
            savedCustomer = customerService.saveCustomerAndAuthority(customerRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in insert Customer : " + errorMessage);
        }

        return savedCustomer;
    }

    @GetMapping(value = "/getAllCustomer",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Customer Details Stored in database")
    public List<Customer> getCustomers()
    {
        List<Customer> customersResponseList = new ArrayList<>();
        customersLogger.info("Get All Customer Details Stored in database");
        try
        {
            customersLogger.info("invoking customerService.getCustomers() service");
            customersResponseList = customerService.getCustomers();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in get all Customer details : " + errorMessage);
        }

        return customersResponseList;
    }

    @GetMapping(value = "/getSingleCustomer/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Customer Details For given Id Stored in database")
    public Customer getCustomerById(@PathVariable Long customerId)
    {
        Customer singleCustomer = new Customer();
        customersLogger.info("Get Customer Details For given Id Stored in database");
        try
        {
            customersLogger.info("invoking customerService.getCustomerById(customerId) service");
            singleCustomer = customerService.getCustomerById(customerId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in get single Customer details : " + errorMessage);
        }

        return singleCustomer;
    }

    @GetMapping(value = "/getAllAuthorityCustomer",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Authority and Customer Details Stored in database")
    public List<Authority> getAllAuthorityWithCustomer()
    {
        List<Authority> authorityCustomersResponseList = new ArrayList<>();
        customersLogger.info("Get All Authority and Customer Details Stored in database");
        try
        {
            customersLogger.info("invoking customerService.getAllAuthorityWithCustomer() service");
            authorityCustomersResponseList = customerService.getAllAuthorityWithCustomer();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in get All Authority and Customer details : " + errorMessage);
        }

        return authorityCustomersResponseList;
    }

    @GetMapping(value = "/getSingleAuthorityCustomer/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Authority and Customer Details For given Id Stored in database")
    public Authority getAuthorityWithCustomerById(@PathVariable Long customerId)
    {
        Authority singleAuthorityCustomer = new Authority();
        customersLogger.info("Get Authority and Customer Details For given Id Stored in database");
        try
        {
            customersLogger.info("invoking customerService.getAuthorityWithCustomerById(customerId) service");
            singleAuthorityCustomer = customerService.getAuthorityWithCustomerById(customerId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            customersLogger.error("Error in get single Authority and Customer Details : " + errorMessage);
        }

        return singleAuthorityCustomer;
    }
}