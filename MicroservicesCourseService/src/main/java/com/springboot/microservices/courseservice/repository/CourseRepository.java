package com.springboot.microservices.courseservice.repository;

import com.springboot.microservices.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>
{
    Course findByCourseName(String courseName);
}
