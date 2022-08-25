package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.AccountTransactionsRequestDto;
import com.springboot.bankingsecurity.entity.AccountTransactions;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.repository.AccountTransactionsRepository;
import com.springboot.bankingsecurity.service.AccountTransactionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountTransactionsServiceImplementation implements AccountTransactionsService
{
    @Autowired
    AccountTransactionsRepository accountTransactionsRepository;

    @Override
    public AccountTransactions saveNewTransactions(AccountTransactionsRequestDto accountTransactionsRequestDto)
    {
        AccountTransactions accountTransactions = new AccountTransactions();
        accountTransactions.setTransactionDt(LocalDateTime.now().toString());
        accountTransactions.setCreateDt(LocalDateTime.now().toString());
        BeanUtils.copyProperties(accountTransactionsRequestDto,accountTransactions);
        AccountTransactions savedTransactions = accountTransactionsRepository.saveAndFlush(accountTransactions);
        return savedTransactions;
    }

    @Override
    public AccountTransactions getBalanceDetails(Long accountTransactionsId)
    {
        AccountTransactions singleTransaction;
        Optional<AccountTransactions> existTransaction = accountTransactionsRepository.findById(accountTransactionsId);
        if(existTransaction.isPresent())
        {
            singleTransaction = existTransaction.get();
        }
        else
        {
            throw new RuntimeException("Transaction with given id not exist");
        }
        return singleTransaction;
    }

    @Override
    public List<AccountTransactions> getAllTransactions()
    {
        List<AccountTransactions> transactionsList = new ArrayList<>();
        transactionsList = accountTransactionsRepository.findAll();
        return transactionsList;
    }

    @Override
    public List<AccountTransactions> getAllTransactionsByCustomerId(Customer customer)
    {
        List<AccountTransactions> transactionsByCustomerIdList = new ArrayList<>();
        transactionsByCustomerIdList = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customer.getCustomerId());
        return transactionsByCustomerIdList;
    }
}
