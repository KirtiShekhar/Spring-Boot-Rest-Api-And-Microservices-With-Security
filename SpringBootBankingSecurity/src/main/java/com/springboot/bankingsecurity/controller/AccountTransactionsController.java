package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.AccountTransactionsRequestDto;
import com.springboot.bankingsecurity.entity.AccountTransactions;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.service.AccountTransactionsService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountTransactionsController
{
    Logger accountTransactionLogger = LoggerFactory.getLogger(AccountTransactionsController.class);

    @Autowired
    AccountTransactionsService accountTransactionsService;

    @RequestMapping("/balance/getBalance")
    public List<AccountTransactions> getAllTransactionsByCustomerId(@RequestBody Customer customer)
    {
        List<AccountTransactions> singleAccountTransactions = new ArrayList<>();
        accountTransactionLogger.info("Get Account Transactions Details For given Id Stored in database");
        try
        {
            accountTransactionLogger.info("invoking accountTransactionsService.getBalanceDetails(accountTransactionsId) service");
            singleAccountTransactions = accountTransactionsService.getAllTransactionsByCustomerId(customer);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            accountTransactionLogger.error("Error in get single Account Transactions details : " + errorMessage);
        }

        return singleAccountTransactions;
    }
}
