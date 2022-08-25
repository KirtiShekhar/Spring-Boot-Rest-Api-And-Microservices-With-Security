package com.springboot.microservices.faculityservice.repository;

import com.springboot.microservices.faculityservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long>
{
    Faculty findByFacultyEmailAddress(String facultyEmailAddress);
}
