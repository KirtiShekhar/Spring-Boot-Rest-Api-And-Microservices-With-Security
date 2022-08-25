package com.springboot.microservices.courseservice.controller;

import com.springboot.microservices.courseservice.constants.Constants;
import com.springboot.microservices.courseservice.dto.CourseInsertResponseDto;
import com.springboot.microservices.courseservice.dto.CourseRequestDto;
import com.springboot.microservices.courseservice.dto.CourseResponseDto;
import com.springboot.microservices.courseservice.response.ResponseMessages;
import com.springboot.microservices.courseservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courseService")
public class CourseServiceController
{
    @Autowired
    CourseService courseService;

    @Autowired
    Environment environment;

    private static final Logger CourseLogger = LoggerFactory.getLogger(CourseServiceController.class);

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        CourseLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        CourseLogger.info("Application MicroservicesCourseService running on port : "+ port);
        return "Application MicroservicesCourseService running on port : "+ port;
    }

    @PostMapping("/courses")
    @Operation(summary = "insert new Course in the database")
    public ResponseEntity<ResponseMessages<CourseInsertResponseDto>> insertCourse(@RequestBody CourseRequestDto courseRequestDto)
    {
        CourseLogger.info("Inserting new course to database");
        ResponseMessages<CourseInsertResponseDto> courseSaveResponseStatement = new ResponseMessages<>();
        HttpStatus courseSaveResponseStatus = HttpStatus.OK;
        try
        {
            CourseLogger.info("invoking courseService.insertCourse(courseRequestDto) service");
            courseSaveResponseStatement = courseService.insertCourse(courseRequestDto);
            courseSaveResponseStatus = HttpStatus.CREATED;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            CourseLogger.error("Error in insert course : ",errorMessage);
            courseSaveResponseStatement.getMessages().addError(errorMessage);
            courseSaveResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(courseSaveResponseStatus).body(courseSaveResponseStatement);
    }

    @GetMapping(value = "/courses",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All courses Stored in database")
    public ResponseEntity<ResponseMessages<List<CourseResponseDto>>> getAllCourses()

    {
        CourseLogger.info("Get All courses Stored in database");
        ResponseMessages<List<CourseResponseDto>> courseResponseListResponseEntityStatement = new ResponseMessages<>();
        HttpStatus courseListResponseStatus = HttpStatus.OK;
        try
        {
            CourseLogger.info("invoking courseService.getAllCourse() service");
            courseResponseListResponseEntityStatement = courseService.getAllCourse();
            courseListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            CourseLogger.error("Error in get all courses : ",errorMessage);
            courseResponseListResponseEntityStatement.getMessages().addError(errorMessage);
            courseListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(courseListResponseStatus).body(courseResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/course/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get course For given Id Stored in database")
    public ResponseEntity<ResponseMessages<CourseResponseDto>> getCourse(@PathVariable Long courseId)
    {
        CourseLogger.info("Get course For given Id Stored in database");
        ResponseMessages<CourseResponseDto> courseResponseSingleResponse = new ResponseMessages<>();
        HttpStatus courseResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            CourseLogger.info("invoking courseService.getCourseById(courseId) service");
            courseResponseSingleResponse = courseService.getCourseById(courseId);
            courseResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            CourseLogger.error("Error in get single course : ",errorMessage);
            courseResponseSingleResponse.getMessages().addError(errorMessage);
            courseResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(courseResponseSingleResponseStatus).body(courseResponseSingleResponse);
    }

    @GetMapping(value = "/allCourses",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All courses Stored in database without responseMessages")
    public ResponseEntity<List<CourseResponseDto>> fetchAllCourse()

    {
        CourseLogger.info("Get All courses Stored in database");
        List<CourseResponseDto> courseResponseListResponseEntityStatement = new ArrayList<>();
        HttpStatus courseListResponseStatus = HttpStatus.OK;
        try
        {
            CourseLogger.info("invoking courseService.getAllCourse() service");
            courseResponseListResponseEntityStatement = courseService.fetchAllCourse();
            courseListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            CourseLogger.error("Error in get all courses : ",errorMessage);
            courseListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(courseListResponseStatus).body(courseResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/singleCourse/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get course For given Id Stored in database without responseMessages")
    public ResponseEntity<CourseResponseDto> getSingleCourse(@PathVariable Long courseId)
    {
        CourseLogger.info("Get course For given Id Stored in database");
        CourseResponseDto courseResponseSingleResponse = new CourseResponseDto();
        HttpStatus courseResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            CourseLogger.info("invoking courseService.getCourseById(courseId) service");
            courseResponseSingleResponse = courseService.getSingleCourse(courseId);
            courseResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            CourseLogger.error("Error in get single course : ",errorMessage);
            courseResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(courseResponseSingleResponseStatus).body(courseResponseSingleResponse);
    }
}
