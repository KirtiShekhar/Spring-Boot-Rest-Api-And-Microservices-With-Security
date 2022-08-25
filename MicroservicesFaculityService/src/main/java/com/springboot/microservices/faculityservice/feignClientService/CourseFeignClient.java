package com.springboot.microservices.faculityservice.feignClientService;

import com.springboot.microservices.faculityservice.feignClientResponse.CourseResponseDto;
import com.springboot.microservices.faculityservice.response.ResponseMessages;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(url = "${courseMicroservice.service.url}",value = "courseMicroservice-feign-client")
public interface CourseFeignClient
{
    @GetMapping(value = "/courseService/course/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseMessages<CourseResponseDto>> getCourse(@PathVariable Long courseId);

    @GetMapping(value = "/courseService/allCourses",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseResponseDto>> fetchAllCourse();

    @GetMapping(value = "/courseService/singleCourse/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseResponseDto> getSingleCourse(@PathVariable Long courseId);
}
