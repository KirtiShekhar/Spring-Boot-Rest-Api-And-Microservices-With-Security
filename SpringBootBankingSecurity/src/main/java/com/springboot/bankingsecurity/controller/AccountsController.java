package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.AccountsRequestDto;
import com.springboot.bankingsecurity.entity.Accounts;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountsController
{
    Logger accountsLogger = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    AccountsService accountsService;

    @RequestMapping("/accounts/getAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer)
    {
        Accounts singleAccount = new Accounts();
        accountsLogger.info("Get account Details For given Id Stored in database");
        try
        {
            accountsLogger.info("invoking accountsService.getAccountDetails(accountsId) service");
            singleAccount = accountsService.getAccountDetailsByCustomerId(customer);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountsLogger.error("Error in get single accounts details : " + errorMessage);
        }

        return singleAccount;
    }
}
