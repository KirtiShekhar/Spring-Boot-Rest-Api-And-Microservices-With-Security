package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.LoansRequestDto;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.entity.Loans;
import java.util.List;

public interface LoansService
{
    Loans saveNewLoans(LoansRequestDto loansRequestDto);
    Loans getLoanById(Long loansId);
    List<Loans> getAllLoans();
    List<Loans> findLoansByCustomerId(Customer customer);
}
