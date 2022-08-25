package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.LoansRequestDto;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.entity.Loans;
import com.springboot.bankingsecurity.repository.CustomerRepository;
import com.springboot.bankingsecurity.service.CustomerService;
import com.springboot.bankingsecurity.service.LoansService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoansController
{
    Logger loansLogger = LoggerFactory.getLogger(LoansController.class);

    @Autowired
    LoansService loansService;

    @RequestMapping("/loans/getLoan")
    public List<Loans> findLoans(@RequestBody Customer customer)
    {
        List<Loans> singleLoans = new ArrayList<>();
        loansLogger.info("Get Loans Details For given Id Stored in database");
        try
        {
            loansLogger.info("invoking loansService.getLoanById(loansId) service");
            singleLoans = loansService.findLoansByCustomerId(customer);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            loansLogger.error("Error in get single Loans details : " + errorMessage);
        }

        return singleLoans;
    }
}
