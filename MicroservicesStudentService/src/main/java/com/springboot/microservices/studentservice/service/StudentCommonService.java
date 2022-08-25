package com.springboot.microservices.studentservice.service;

import com.springboot.microservices.studentservice.dto.StudentCourseAddressListOfResponse;

import java.util.List;

public interface StudentCommonService
{
    List<StudentCourseAddressListOfResponse> getListOfStudentAddressAndCourse();
}
