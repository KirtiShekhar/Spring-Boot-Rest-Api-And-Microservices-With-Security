package com.springboot.microservices.studentservice.repository;

import com.springboot.microservices.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long>
{
    Student findByStudentEmailAddress(String studentEmailAddress);
}
