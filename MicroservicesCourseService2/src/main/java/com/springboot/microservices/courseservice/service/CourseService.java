package com.springboot.microservices.courseservice.service;

import java.util.List;

import com.springboot.microservices.courseservice.dto.CourseInsertResponseDto;
import com.springboot.microservices.courseservice.dto.CourseRequestDto;
import com.springboot.microservices.courseservice.dto.CourseResponseDto;
import com.springboot.microservices.courseservice.response.ResponseMessages;

public interface CourseService
{
    ResponseMessages<CourseInsertResponseDto> insertCourse(CourseRequestDto courseRequestDto);
    ResponseMessages<List<CourseResponseDto>> getAllCourse();
    ResponseMessages<CourseResponseDto> getCourseById(Long courseId);
}
