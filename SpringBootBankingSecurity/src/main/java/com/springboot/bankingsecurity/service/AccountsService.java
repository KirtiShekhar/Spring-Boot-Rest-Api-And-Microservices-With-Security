package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.AccountsRequestDto;
import com.springboot.bankingsecurity.entity.Accounts;
import com.springboot.bankingsecurity.entity.Customer;

import java.util.List;

public interface AccountsService
{
    Accounts saveAccountDetails(AccountsRequestDto accountsRequestDto);
    Accounts getAccountDetails(Long accountsId);
    List<Accounts> getAllAccounts();
    Accounts getAccountDetailsByCustomerId(Customer customer);
}
