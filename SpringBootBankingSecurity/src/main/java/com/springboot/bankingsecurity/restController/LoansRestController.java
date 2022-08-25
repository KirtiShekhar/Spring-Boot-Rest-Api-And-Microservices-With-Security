package com.springboot.bankingsecurity.restController;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.LoansRequestDto;
import com.springboot.bankingsecurity.entity.Loans;
import com.springboot.bankingsecurity.service.LoansService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansRestController
{
    Logger loansLogger = LoggerFactory.getLogger(LoansRestController.class);

    @Autowired
    LoansService loansService;

    @PostMapping(value = "/saveLoans",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Loans in the database")
    public Loans saveNewLoans(@RequestBody LoansRequestDto loansRequestDto)
    {
        Loans savedLoans = new Loans();
        loansLogger.info("Inserting new Loans to database");
        try
        {
            loansLogger.info("invoking loansService.saveNewLoans(loansRequestDto) service");
            savedLoans = loansService.saveNewLoans(loansRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            loansLogger.error("Error in insert Loans : " + errorMessage);
        }

        return savedLoans;
    }

    @GetMapping(value = "/getAllLoans",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Loans Details Stored in database")
    public List<Loans> getAllLoans()
    {
        List<Loans> loansResponseList = new ArrayList<>();
        loansLogger.info("Get All Loans Details Stored in database");
        try
        {
            loansLogger.info("invoking loansService.getAllLoans() service");
            loansResponseList = loansService.getAllLoans();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            loansLogger.error("Error in get all Loans details : " + errorMessage);
        }

        return loansResponseList;
    }

    @GetMapping(value = "/getSingleLoans/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Loans Details For given Id Stored in database")
    public Loans getLoanById(@PathVariable Long loansId)
    {
        Loans singleLoans = new Loans();
        loansLogger.info("Get Loans Details For given Id Stored in database");
        try
        {
            loansLogger.info("invoking loansService.getLoanById(loansId) service");
            singleLoans = loansService.getLoanById(loansId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            loansLogger.error("Error in get single Loans details : " + errorMessage);
        }

        return singleLoans;
    }
}
