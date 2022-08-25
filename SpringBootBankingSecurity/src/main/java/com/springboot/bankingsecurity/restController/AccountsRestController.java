package com.springboot.bankingsecurity.restController;

import com.springboot.bankingsecurity.dto.AccountsRequestDto;
import com.springboot.bankingsecurity.entity.Accounts;
import com.springboot.bankingsecurity.service.AccountsService;
import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
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
@RequestMapping("/accounts")
public class AccountsRestController
{
    Logger accountsLogger = LoggerFactory.getLogger(AccountsRestController.class);

    @Autowired
    AccountsService accountsService;

    @PostMapping(value = "/saveAccount",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new account in the database")
    public Accounts saveAccountDetails(@RequestBody AccountsRequestDto accountsRequestDto)
    {
        Accounts savedAccounts = new Accounts();
        accountsLogger.info("Inserting new account to database");
        try
        {
            accountsLogger.info("invoking accountsService.saveAccountDetails(accountsRequestDto) service");
            savedAccounts = accountsService.saveAccountDetails(accountsRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountsLogger.error("Error in insert account : " + errorMessage);
        }

        return savedAccounts;
    }

    @GetMapping(value = "/getAllAccounts",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Account Details Stored in database")
    public List<Accounts> getAllAccounts()
    {
        List<Accounts> accountsResponseList = new ArrayList<>();
        accountsLogger.info("Get All Account Details Stored in database");
        try
        {
            accountsLogger.info("invoking accountsService.getAllAccounts() service");
            accountsResponseList = accountsService.getAllAccounts();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountsLogger.error("Error in get all accounts details : " + errorMessage);
        }

        return accountsResponseList;
    }

    @GetMapping(value = "/getSingleAccount/{accountsId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get account Details For given Id Stored in database")
    public Accounts getAccountDetails(@PathVariable Long accountsId)
    {
        Accounts singleAccount = new Accounts();
        accountsLogger.info("Get account Details For given Id Stored in database");
        try
        {
            accountsLogger.info("invoking accountsService.getAccountDetails(accountsId) service");
            singleAccount = accountsService.getAccountDetails(accountsId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountsLogger.error("Error in get single accounts details : " + errorMessage);
        }

        return singleAccount;
    }
}
