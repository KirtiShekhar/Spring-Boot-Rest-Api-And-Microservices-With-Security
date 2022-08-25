package com.springboot.microservices.faculityservice.service;

import com.springboot.microservices.faculityservice.dto.*;
import com.springboot.microservices.faculityservice.response.ResponseMessages;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface FacultyService
{
    ResponseMessages<FacultyInsertResponseDto> insertFaculty(FacultyRequestDto facultyRequestDto);
    ResponseMessages<List<FacultyResponseDto>> getAllFaculty();
    ResponseMessages<FacultyResponseDto> getFacultyById(Long facultyId);
    ResponseMessages<FacultyDetailResponseDto> getFacultyWithAddressAndCourse(@PathVariable Long facultyId,@PathVariable Long addressId,@PathVariable Long courseId);
    List<FacultyResponseDto> fetchAllFaculty();
    FacultyResponseDto getSingleFaculty(Long facultyId);
    FacultyCourseAddressSingleResponse getSingleFacultyAddressAndCourse(@PathVariable Long facultyId, @PathVariable Long addressId, @PathVariable Long courseId);
    List<FacultyCourseAddressListOfResponse> getListOfFacultyAddressAndCourse();
}
