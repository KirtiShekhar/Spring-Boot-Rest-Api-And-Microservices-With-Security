package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.AccountsRequestDto;
import com.springboot.bankingsecurity.entity.Accounts;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.repository.AccountsRepository;
import com.springboot.bankingsecurity.service.AccountsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImplementation implements AccountsService
{
    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public Accounts saveAccountDetails(AccountsRequestDto accountsRequestDto)
    {
        Accounts accounts = new Accounts();
        accountsRequestDto.setCreateDt(LocalDateTime.now().toString());
        BeanUtils.copyProperties(accountsRequestDto,accounts);
        Accounts savedAccounts = accountsRepository.saveAndFlush(accounts);
        return savedAccounts;
    }

    @Override
    public Accounts getAccountDetails(Long accountsId)
    {
        Accounts singleAccounts;
        Optional<Accounts> existAccounts = accountsRepository.findById(accountsId);
        if(existAccounts.isPresent())
        {
            singleAccounts = existAccounts.get();
        }
        else
        {
            throw new RuntimeException("Account with given id not exist");
        }
        return singleAccounts;
    }

    @Override
    public List<Accounts> getAllAccounts()
    {
        List<Accounts> accountsList = new ArrayList<>();
        accountsList = accountsRepository.findAll();
        return accountsList;
    }

    @Override
    public Accounts getAccountDetailsByCustomerId(Customer customer)
    {
        Accounts singleAccounts;
        singleAccounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        return singleAccounts;
    }
}
