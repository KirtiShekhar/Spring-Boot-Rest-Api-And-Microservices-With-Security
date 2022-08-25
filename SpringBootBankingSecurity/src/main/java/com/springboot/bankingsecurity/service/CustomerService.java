package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.CustomerRequestDto;
import com.springboot.bankingsecurity.entity.Authority;
import com.springboot.bankingsecurity.entity.Customer;

import java.security.Principal;
import java.util.List;

public interface CustomerService
{
    Customer saveCustomerAndAuthority(CustomerRequestDto customerRequestDto);
    Customer getCustomerById(Long customerId);
    List<Customer> getCustomers();
    Authority getAuthorityWithCustomerById(Long customerId);
    List<Authority> getAllAuthorityWithCustomer();
    Customer getUserDetailsAfterLogin(Principal customer);
}
