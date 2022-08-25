package com.springboot.bankingsecurity.config;

import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankingApplicationUsernamePasswordAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication)
    {
        String customerUsername = authentication.getName();
        String customerPassword = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findByCustomerEmailAddress(customerUsername);
        if(customer.size() > 0)
        {
            if(passwordEncoder.matches(customerPassword,customer.get(0).getCustomerPassword()))
            {
                List<GrantedAuthority> customerAuthorities = new ArrayList<>();
                customerAuthorities.add(new SimpleGrantedAuthority(customer.get(0).getCustomerRole()));
                return new UsernamePasswordAuthenticationToken(customerUsername,customerPassword,customerAuthorities);
            }
            else
            {
                throw new BadCredentialsException("Invalid Password");
            }
        }
        else
        {
            throw new BadCredentialsException("No user registered with this details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
