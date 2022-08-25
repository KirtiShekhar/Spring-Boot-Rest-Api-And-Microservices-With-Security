package com.springboot.bankingsecurity.repository;

import com.springboot.bankingsecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
    List<Customer> findByCustomerEmailAddress(String customerEmailAddress);
}
