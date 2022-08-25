package com.springboot.microservices.studentservice.controller;

import com.springboot.microservices.studentservice.constants.Constants;
import com.springboot.microservices.studentservice.dto.*;
import com.springboot.microservices.studentservice.response.ResponseMessages;
import com.springboot.microservices.studentservice.service.StudentCommonService;
import com.springboot.microservices.studentservice.service.StudentService;
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
@RequestMapping("/studentService")
public class StudentServiceController
{
    @Autowired
    StudentService studentService;

    @Autowired
    StudentCommonService studentCommonService;

    @Autowired
    Environment environment;

    private static final Logger StudentsLogger = LoggerFactory.getLogger(StudentServiceController.class);

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        StudentsLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        StudentsLogger.info("Application MicroservicesStudentService running on port : "+ port);
        return "Application MicroservicesStudentService running on port : "+ port;
    }

    @PostMapping(value = "/students",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new student in the database")
    public ResponseEntity<ResponseMessages<StudentInsertResponseDto>> saveStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        StudentsLogger.info("Inserting new student to database");
        ResponseMessages<StudentInsertResponseDto> studentSaveResponseStatement = new ResponseMessages<>();
        HttpStatus studentSaveResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.insertStudent(studentRequestDto) service");
            studentSaveResponseStatement = studentService.insertStudent(studentRequestDto);
            studentSaveResponseStatus = HttpStatus.CREATED;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in insert student : ",errorMessage);
            studentSaveResponseStatement.getMessages().addError(errorMessage);
            studentSaveResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentSaveResponseStatus).body(studentSaveResponseStatement);
    }

    @GetMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Students Stored in database")
    public ResponseEntity<ResponseMessages<List<StudentResponseDto>>> getAllStudents()
    {
        StudentsLogger.info("Get All Students Stored in database");
        ResponseMessages<List<StudentResponseDto>> studentResponseListResponseEntityStatement = new ResponseMessages<>();
        HttpStatus studentListResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getAllStudent() service");
            studentResponseListResponseEntityStatement = studentService.getAllStudent();
            studentListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get all students : ",errorMessage);
            studentResponseListResponseEntityStatement.getMessages().addError(errorMessage);
            studentListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentListResponseStatus).body(studentResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/student/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get student For given Id Stored in database without responseMessages")
    public ResponseEntity<ResponseMessages<StudentResponseDto>> getStudent(@PathVariable Long studentId)
    {
        StudentsLogger.info("Get Student For given Id Stored in database");
        ResponseMessages<StudentResponseDto> studentResponseSingleResponse = new ResponseMessages<>();
        HttpStatus studentResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getStudentById(studentId) service");
            studentResponseSingleResponse = studentService.getStudentById(studentId);
            studentResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get single student : ",errorMessage);
            studentResponseSingleResponse.getMessages().addError(errorMessage);
            studentResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentResponseSingleResponseStatus).body(studentResponseSingleResponse);
    }

    @GetMapping(value = "/allStudents",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Students Stored in database without responseMessages")
    public ResponseEntity<List<StudentResponseDto>> fetchAllStudent()
    {
        StudentsLogger.info("Get All Students Stored in database");
        List<StudentResponseDto> studentResponseListResponseEntityStatement = new ArrayList<>();
        HttpStatus studentListResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getAllStudent() service");
            studentResponseListResponseEntityStatement = studentService.fetchAllStudent();
            studentListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get all students : ",errorMessage);
            studentListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentListResponseStatus).body(studentResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/singleStudent/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get student For given Id Stored in database")
    public ResponseEntity<StudentResponseDto> getSingleStudent(@PathVariable Long studentId)
    {
        StudentsLogger.info("Get Student For given Id Stored in database");
        StudentResponseDto studentResponseSingleResponse = new StudentResponseDto();
        HttpStatus studentResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getStudentById(studentId) service");
            studentResponseSingleResponse = studentService.getSingleStudent(studentId);
            studentResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get single student : ",errorMessage);
            studentResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentResponseSingleResponseStatus).body(studentResponseSingleResponse);
    }

    @GetMapping(value = "/student/{studentId}/address/{addressId}/course/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get student Along with address and course For given Id Stored in database using feign client")
    public ResponseEntity<ResponseMessages<StudentDetailResponseDto>> getStudentWithAddressAndCourse(@PathVariable Long studentId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        StudentsLogger.info("Get student Along with address and course For given Id Stored in database using feign client");
        ResponseMessages<StudentDetailResponseDto> studentDetailResponseSingleResponse = new ResponseMessages<>();
        HttpStatus studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getStudentWithAddressAndCourse(studentId,addressId,courseId) service");
            studentDetailResponseSingleResponse = studentService.getStudentWithAddressAndCourse(studentId,addressId,courseId);
            studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get single student : ",errorMessage);
            studentDetailResponseSingleResponse.getMessages().addError(errorMessage);
            studentDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentDetailResponseSingleResponseStatus).body(studentDetailResponseSingleResponse);
    }

    @GetMapping(value = "/singleStudent/{studentId}/singleAddress/{addressId}/singleCourse/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get student Along with address and course For given Id Stored in database using feign client without responseMessages")
    public ResponseEntity<StudentCourseAddressSingleResponse> getSingleStudentAddressAndCourse(@PathVariable Long studentId, @PathVariable Long addressId, @PathVariable Long courseId)
    {
        StudentsLogger.info("Get student Along with address and course For given Id Stored in database using feign client");
        StudentCourseAddressSingleResponse studentDetailResponseSingleResponse = new StudentCourseAddressSingleResponse();
        HttpStatus studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getStudentWithAddressAndCourse(studentId,addressId,courseId) service");
            studentDetailResponseSingleResponse = studentService.getSingleStudentAddressAndCourse(studentId,addressId,courseId);
            studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get single student : ",errorMessage);
            studentDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentDetailResponseSingleResponseStatus).body(studentDetailResponseSingleResponse);
    }

    @GetMapping(value = "/allStudent/allAddress/allCourse",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All student Along with address and course Stored in database using feign client without responseMessages")
    public ResponseEntity<List<StudentCourseAddressListOfResponse>> getListOfStudentAddressAndCourse()
    {
        StudentsLogger.info("Get student Along with address and course For given Id Stored in database using feign client");
        List<StudentCourseAddressListOfResponse> studentCourseAddressListResponses = new ArrayList<>();
        HttpStatus studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            StudentsLogger.info("invoking studentService.getStudentWithAddressAndCourse(studentId,addressId,courseId) service");
            studentCourseAddressListResponses = studentCommonService.getListOfStudentAddressAndCourse();
            studentDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            StudentsLogger.error("Error in get single student : ",errorMessage);
            studentDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(studentDetailResponseSingleResponseStatus).body(studentCourseAddressListResponses);
    }
}
