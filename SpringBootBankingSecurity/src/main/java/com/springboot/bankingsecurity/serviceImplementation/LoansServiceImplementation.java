package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.LoansRequestDto;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.entity.Loans;
import com.springboot.bankingsecurity.repository.CustomerRepository;
import com.springboot.bankingsecurity.repository.LoansRepository;
import com.springboot.bankingsecurity.service.LoansService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoansServiceImplementation implements LoansService
{
    @Autowired
    LoansRepository loansRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Loans saveNewLoans(LoansRequestDto loansRequestDto)
    {
        Loans loans = new Loans();
        loansRequestDto.setCreateDt(LocalDateTime.now().toString());
        loansRequestDto.setStartDt(LocalDateTime.now().toString());
        BeanUtils.copyProperties(loansRequestDto,loans);
        Loans savedLoans = loansRepository.saveAndFlush(loans);
        return savedLoans;
    }

    @Override
    public Loans getLoanById(Long loansId)
    {
        Loans singleLoan;
        Optional<Loans> existLoan = loansRepository.findById(loansId);
        if(existLoan.isPresent())
        {
            singleLoan = existLoan.get();
        }
        else
        {
            throw new RuntimeException("Loan Details with given id not exist");
        }
        return singleLoan;
    }

    @Override
    public List<Loans> getAllLoans()
    {
        List<Loans> loansList = new ArrayList<>();
        loansList = loansRepository.findAll();
        return loansList;
    }

    @Override
    public List<Loans> findLoansByCustomerId(Customer customer)
    {
        List<Loans> loansByCustomerIdList = new ArrayList<>();
        loansByCustomerIdList = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        return loansByCustomerIdList;
    }
}
