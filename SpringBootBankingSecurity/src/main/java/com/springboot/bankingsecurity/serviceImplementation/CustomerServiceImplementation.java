package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.CustomerRequestDto;
import com.springboot.bankingsecurity.entity.Authority;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.repository.AuthorityRepository;
import com.springboot.bankingsecurity.repository.CustomerRepository;
import com.springboot.bankingsecurity.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Customer saveCustomerAndAuthority(CustomerRequestDto customerRequestDto)
    {
        Customer customer = new Customer();
        customerRequestDto.setCustomerPassword(passwordEncoder.encode("Kirti@31"));
        BeanUtils.copyProperties(customerRequestDto,customer);
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;
    }

    @Override
    public Customer getCustomerById(Long customerId)
    {
        Customer singleCustomer;
        Optional<Customer> existCustomer = customerRepository.findById(customerId);
        if(existCustomer.isPresent())
        {
            singleCustomer = existCustomer.get();
        }
        else
        {
            throw new RuntimeException("Customer with given id not exist");
        }
        return singleCustomer;
    }

    @Override
    public List<Customer> getCustomers()
    {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerRepository.findAll();
        return customerList;
    }

    @Override
    public Authority getAuthorityWithCustomerById(Long customerId)
    {
        Authority singleAuthorityCustomer;
        Optional<Authority> existAuthorityCustomer = authorityRepository.findById(customerId);
        if(existAuthorityCustomer.isPresent())
        {
            singleAuthorityCustomer = existAuthorityCustomer.get();
        }
        else
        {
            throw new RuntimeException("Authority and Customer with given id not exist");
        }
        return singleAuthorityCustomer;
    }

    @Override
    public List<Authority> getAllAuthorityWithCustomer()
    {
        List<Authority> authorityCustomerList = new ArrayList<>();
        authorityCustomerList = authorityRepository.findAll();
        return authorityCustomerList;
    }

    @Override
    public Customer getUserDetailsAfterLogin(Principal customer)
    {
        List<Customer> customers = customerRepository.findByCustomerEmailAddress(customer.getName());
        if (customers.size() > 0)
        {
            System.out.println(customers.get(0).getCustomerId() + customers.get(0).getCustomerFullName() +
                    customers.get(0).getCustomerEmailAddress() + customers.get(0).getCustomerContactNumber());
            return customers.get(0);
        }else {
            return null;
        }
    }
}
