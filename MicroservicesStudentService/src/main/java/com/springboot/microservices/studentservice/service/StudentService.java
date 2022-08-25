package com.springboot.microservices.studentservice.service;

import java.util.List;

import com.springboot.microservices.studentservice.dto.StudentDetailResponseDto;
import com.springboot.microservices.studentservice.dto.StudentRequestDto;
import com.springboot.microservices.studentservice.dto.StudentInsertResponseDto;
import com.springboot.microservices.studentservice.dto.StudentResponseDto;
import com.springboot.microservices.studentservice.dto.StudentCourseAddressListOfResponse;
import com.springboot.microservices.studentservice.dto.StudentCourseAddressSingleResponse;
import com.springboot.microservices.studentservice.response.ResponseMessages;
import org.springframework.web.bind.annotation.PathVariable;

public interface StudentService
{
    ResponseMessages<StudentInsertResponseDto> insertStudent(StudentRequestDto studentRequestDto);
    ResponseMessages<List<StudentResponseDto>> getAllStudent();
    ResponseMessages<StudentResponseDto> getStudentById(Long studentId);
    ResponseMessages<StudentDetailResponseDto> getStudentWithAddressAndCourse(@PathVariable Long studentId,@PathVariable Long addressId,@PathVariable Long courseId);
    List<StudentResponseDto> fetchAllStudent();
    StudentResponseDto getSingleStudent(Long studentId);
    StudentCourseAddressSingleResponse getSingleStudentAddressAndCourse(@PathVariable Long studentId, @PathVariable Long addressId, @PathVariable Long courseId);

}
