package com.springboot.microservices.faculityservice.controller;

import com.springboot.microservices.faculityservice.constants.Constants;
import com.springboot.microservices.faculityservice.dto.*;
import com.springboot.microservices.faculityservice.response.ResponseMessages;
import com.springboot.microservices.faculityservice.service.FacultyService;
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
@RequestMapping("/facultyService")
public class FacultyServiceController
{
    @Autowired
    FacultyService facultyService;

    @Autowired
    Environment environment;

    private static final Logger FacultyLogger = LoggerFactory.getLogger(FacultyServiceController.class);

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        FacultyLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        FacultyLogger.info("Application MicroservicesFacultyService running on port : "+ port);
        return "Application MicroservicesFacultyService running on port : "+ port;
    }

    @PostMapping(value = "/faculties",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Faculty in the database")
    public ResponseEntity<ResponseMessages<FacultyInsertResponseDto>> insertFaculty(@RequestBody FacultyRequestDto facultyRequestDto)
    {
        FacultyLogger.info("Inserting new Faculty to database");
        ResponseMessages<FacultyInsertResponseDto> facultySaveResponseStatement = new ResponseMessages<>();
        HttpStatus facultySaveResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.insertFaculty(facultyRequestDto) service");
            facultySaveResponseStatement = facultyService.insertFaculty(facultyRequestDto);
            facultySaveResponseStatus = HttpStatus.CREATED;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in insert faculty : ",errorMessage);
            facultySaveResponseStatement.getMessages().addError(errorMessage);
            facultySaveResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultySaveResponseStatus).body(facultySaveResponseStatement);
    }

    @GetMapping(value = "/faculties",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Faculties Stored in database")
    public ResponseEntity<ResponseMessages<List<FacultyResponseDto>>> getAllFaculty()
    {
        FacultyLogger.info("Get All Faculties Stored in database");
        ResponseMessages<List<FacultyResponseDto>> facultyResponseListResponseEntityStatement = new ResponseMessages<>();
        HttpStatus facultyListResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getAllFaculty() service");
            facultyResponseListResponseEntityStatement = facultyService.getAllFaculty();
            facultyListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get all faculties : ",errorMessage);
            facultyResponseListResponseEntityStatement.getMessages().addError(errorMessage);
            facultyListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyListResponseStatus).body(facultyResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/faculty/{facultyId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Faculty For given Id Stored in database")
    public ResponseEntity<ResponseMessages<FacultyResponseDto>> getFaculty(@PathVariable Long facultyId)
    {
        FacultyLogger.info("Get Faculty For given Id Stored in database");
        ResponseMessages<FacultyResponseDto> facultyResponseSingleResponse = new ResponseMessages<>();
        HttpStatus facultyResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getFacultyById(facultyId) service");
            facultyResponseSingleResponse = facultyService.getFacultyById(facultyId);
            facultyResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get single faculty : ",errorMessage);
            facultyResponseSingleResponse.getMessages().addError(errorMessage);
            facultyResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyResponseSingleResponseStatus).body(facultyResponseSingleResponse);
    }

    @GetMapping(value = "/allFaculties",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Faculties Stored in database without responseMessages")
    public ResponseEntity<List<FacultyResponseDto>> fetchAllFaculty()
    {
        FacultyLogger.info("Get All Faculties Stored in database");
        List<FacultyResponseDto> facultyResponseListResponseEntityStatement = new ArrayList<>();
        HttpStatus facultyListResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getAllFaculty() service");
            facultyResponseListResponseEntityStatement = facultyService.fetchAllFaculty();
            facultyListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get all faculties : ",errorMessage);
            facultyListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyListResponseStatus).body(facultyResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/singleFaculty/{facultyId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Faculty For given Id Stored in database without responseMessages")
    public ResponseEntity<FacultyResponseDto> getSingleFaculty(@PathVariable Long facultyId)
    {
        FacultyLogger.info("Get Faculty For given Id Stored in database");
        FacultyResponseDto facultyResponseSingleResponse = new FacultyResponseDto();
        HttpStatus facultyResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getFacultyById(facultyId) service");
            facultyResponseSingleResponse = facultyService.getSingleFaculty(facultyId);
            facultyResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get single faculty : ",errorMessage);
            facultyResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyResponseSingleResponseStatus).body(facultyResponseSingleResponse);
    }

    @GetMapping(value = "/faculty/{facultyId}/address/{addressId}/course/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Faculty Along with address and course For given Id Stored in database using feign client")
    public ResponseEntity<ResponseMessages<FacultyDetailResponseDto>> getFacultyWithAddressAndCourse(@PathVariable Long facultyId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        FacultyLogger.info("Get Faculty Along with address and course For given Id Stored in database using feign client");
        ResponseMessages<FacultyDetailResponseDto> facultyDetailResponseSingleResponse = new ResponseMessages<>();
        HttpStatus facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getFacultyWithAddressAndCourse(facultyId,addressId,courseId) service");
            facultyDetailResponseSingleResponse = facultyService.getFacultyWithAddressAndCourse(facultyId,addressId,courseId);
            facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get single faculty : ",errorMessage);
            facultyDetailResponseSingleResponse.getMessages().addError(errorMessage);
            facultyDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyDetailResponseSingleResponseStatus).body(facultyDetailResponseSingleResponse);
    }

    @GetMapping(value = "/singleFaculty/{facultyId}/singleAddress/{addressId}/singleCourse/{courseId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Faculty Along with address and course For given Id Stored in database using feign client without responseMessages")
    public ResponseEntity<FacultyCourseAddressSingleResponse> getSingleFacultyAddressAndCourse(@PathVariable Long facultyId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        FacultyLogger.info("Get Faculty Along with address and course For given Id Stored in database using feign client");
        FacultyCourseAddressSingleResponse facultyAddressCourseSingleResponse = new FacultyCourseAddressSingleResponse();
        HttpStatus facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getFacultyWithAddressAndCourse(facultyId,addressId,courseId) service");
            facultyAddressCourseSingleResponse = facultyService.getSingleFacultyAddressAndCourse(facultyId,addressId,courseId);
            facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get single faculty : ",errorMessage);
            facultyDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyDetailResponseSingleResponseStatus).body(facultyAddressCourseSingleResponse);
    }

    @GetMapping(value = "/allFaculty/allAddress/allCourse",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Faculty Along with address and course Stored in database using feign client without responseMessages")
    public ResponseEntity<List<FacultyCourseAddressListOfResponse>> getListOfFacultyAddressAndCourse()
    {
        FacultyLogger.info("Get Faculty Along with address and course For given Id Stored in database using feign client");
        List<FacultyCourseAddressListOfResponse> facultyAddressCourseListResponse = new ArrayList<>();
        HttpStatus facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            FacultyLogger.info("invoking facultyService.getFacultyWithAddressAndCourse(facultyId,addressId,courseId) service");
            facultyAddressCourseListResponse = facultyService.getListOfFacultyAddressAndCourse();
            facultyDetailResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            FacultyLogger.error("Error in get single faculty : ",errorMessage);
            facultyDetailResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(facultyDetailResponseSingleResponseStatus).body(facultyAddressCourseListResponse);
    }
}
