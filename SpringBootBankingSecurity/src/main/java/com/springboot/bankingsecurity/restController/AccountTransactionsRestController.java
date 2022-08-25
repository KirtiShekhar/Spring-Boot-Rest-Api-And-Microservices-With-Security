package com.springboot.bankingsecurity.restController;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.AccountTransactionsRequestDto;
import com.springboot.bankingsecurity.entity.AccountTransactions;
import com.springboot.bankingsecurity.service.AccountTransactionsService;
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
@RequestMapping("/balance")
public class AccountTransactionsRestController
{
    Logger accountTransactionLogger = LoggerFactory.getLogger(AccountTransactionsRestController.class);

    @Autowired
    AccountTransactionsService accountTransactionsService;

    @PostMapping(value = "/saveBalance",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Account Transactions in the database")
    public AccountTransactions saveNewTransactions(@RequestBody AccountTransactionsRequestDto accountTransactionsRequestDto)
    {
        AccountTransactions savedAccountTransactions = new AccountTransactions();
        accountTransactionLogger.info("Inserting new Account Transactions to database");
        try
        {
            accountTransactionLogger.info("invoking accountTransactionsService.saveNewTransactions(accountTransactionsRequestDto) service");
            savedAccountTransactions = accountTransactionsService.saveNewTransactions(accountTransactionsRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountTransactionLogger.error("Error in insert Account Transactions : " + errorMessage);
        }

        return savedAccountTransactions;
    }

    @GetMapping(value = "/getAllBalance",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Account Transactions Details Stored in database")
    public List<AccountTransactions> getAllTransactions()
    {
        List<AccountTransactions> accountTransactionsResponseList = new ArrayList<>();
        accountTransactionLogger.info("Get All Account Transactions Details Stored in database");
        try
        {
            accountTransactionLogger.info("invoking accountTransactionsService.getAllTransactions() service");
            accountTransactionsResponseList = accountTransactionsService.getAllTransactions();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountTransactionLogger.error("Error in get all Account Transactions details : " + errorMessage);
        }

        return accountTransactionsResponseList;
    }

    @GetMapping(value = "/getSingleBalance/{accountTransactionsId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Account Transactions Details For given Id Stored in database")
    public AccountTransactions getBalanceDetails(@PathVariable Long accountTransactionsId)
    {
        AccountTransactions singleAccountTransactions = new AccountTransactions();
        accountTransactionLogger.info("Get Account Transactions Details For given Id Stored in database");
        try
        {
            accountTransactionLogger.info("invoking accountTransactionsService.getBalanceDetails(accountTransactionsId) service");
            singleAccountTransactions = accountTransactionsService.getBalanceDetails(accountTransactionsId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountTransactionLogger.error("Error in get single Account Transactions details : " + errorMessage);
        }

        return singleAccountTransactions;
    }


}
