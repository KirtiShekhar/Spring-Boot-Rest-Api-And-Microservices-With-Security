package com.springboot.bankingsecurity.repository;

import com.springboot.bankingsecurity.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long>
{
}
