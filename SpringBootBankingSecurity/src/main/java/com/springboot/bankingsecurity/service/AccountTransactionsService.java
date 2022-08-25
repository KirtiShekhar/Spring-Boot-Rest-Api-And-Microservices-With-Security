package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.AccountTransactionsRequestDto;
import com.springboot.bankingsecurity.entity.AccountTransactions;
import com.springboot.bankingsecurity.entity.Customer;

import java.util.List;

public interface AccountTransactionsService
{
    AccountTransactions saveNewTransactions(AccountTransactionsRequestDto accountTransactionsRequestDto);
    AccountTransactions getBalanceDetails(Long accountTransactionsId);
    List<AccountTransactions> getAllTransactions();
    List<AccountTransactions> getAllTransactionsByCustomerId(Customer customer);
}
