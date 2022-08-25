package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.entity.CustomerSecurity;
import com.springboot.bankingsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCustomerDetailsService implements UserDetailsService
{
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<Customer> customer = customerRepository.findByCustomerEmailAddress(username);
        if(customer.size() == 0)
        {
            throw new UsernameNotFoundException("user details not found for the user : " + username);
        }
        System.out.println("User found for the user : " + username);
        return new CustomerSecurity(customer.get(0));
    }
}
