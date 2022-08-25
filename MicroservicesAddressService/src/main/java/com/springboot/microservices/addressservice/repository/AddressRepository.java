package com.springboot.microservices.addressservice.repository;

import com.springboot.microservices.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>
{
    Address findByState(String state);
}
