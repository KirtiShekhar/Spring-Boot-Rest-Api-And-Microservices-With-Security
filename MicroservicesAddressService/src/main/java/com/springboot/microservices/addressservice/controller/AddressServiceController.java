package com.springboot.microservices.addressservice.controller;

import com.springboot.microservices.addressservice.constants.Constants;
import com.springboot.microservices.addressservice.response.ResponseMessages;
import com.springboot.microservices.addressservice.service.AddressService;
import com.springboot.microservices.addressservice.dto.AddressRequestDto;
import com.springboot.microservices.addressservice.dto.AddressInsertResponseDto;
import com.springboot.microservices.addressservice.dto.AddressResponseDto;
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
@RequestMapping("/addressService")
public class AddressServiceController
{
    @Autowired
    AddressService addressService;
    
    @Autowired
    Environment environment;

    private static final Logger AddressLogger = LoggerFactory.getLogger(AddressServiceController.class);

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        AddressLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        AddressLogger.info("Application MicroservicesAddressService running on port : "+ port);
        return "Application MicroservicesAddressService running on port : "+ port;
    }

    @PostMapping(value = "/addresses",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new address in the database")
    public ResponseEntity<ResponseMessages<AddressInsertResponseDto>> insertAddress(@RequestBody AddressRequestDto addressRequestDto)
    {
        AddressLogger.info("Inserting new address to database");
        ResponseMessages<AddressInsertResponseDto> addressSaveResponseStatement = new ResponseMessages<>();
        HttpStatus addressSaveResponseStatus = HttpStatus.OK;
        try
        {
            AddressLogger.info("invoking addressService.insertAddress(addressRequestDto) service");
            addressSaveResponseStatement = addressService.insertAddress(addressRequestDto);
            addressSaveResponseStatus = HttpStatus.CREATED;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            AddressLogger.error("Error in insert address : ",errorMessage);
            addressSaveResponseStatement.getMessages().addError(errorMessage);
            addressSaveResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(addressSaveResponseStatus).body(addressSaveResponseStatement);
    }

    @GetMapping(value = "/addresses",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Address Stored in database")
    public ResponseEntity<ResponseMessages<List<AddressResponseDto>>> getAllAddress()
    {
        AddressLogger.info("Get All Address Stored in database");
        ResponseMessages<List<AddressResponseDto>> addressResponseListResponseEntityStatement = new ResponseMessages<>();
        HttpStatus addressListResponseStatus = HttpStatus.OK;
        try
        {
            AddressLogger.info("invoking addressService.getAllAddress() service");
            addressResponseListResponseEntityStatement = addressService.getAllAddress();
            addressListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            AddressLogger.error("Error in get all address : ",errorMessage);
            addressResponseListResponseEntityStatement.getMessages().addError(errorMessage);
            addressListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(addressListResponseStatus).body(addressResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/address/{addressId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Address For given Id Stored in database")
    public ResponseEntity<ResponseMessages<AddressResponseDto>> getAddress(@PathVariable Long addressId)
    {
        AddressLogger.info("Get Address For given Id Stored in database");
        ResponseMessages<AddressResponseDto> addressResponseSingleResponse = new ResponseMessages<>();
        HttpStatus addressResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            AddressLogger.info("invoking addressService.getAddressById(addressId) service");
            addressResponseSingleResponse = addressService.getAddressById(addressId);
            addressResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            AddressLogger.error("Error in get single address : ",errorMessage);
            addressResponseSingleResponse.getMessages().addError(errorMessage);
            addressResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(addressResponseSingleResponseStatus).body(addressResponseSingleResponse);
    }

    @GetMapping(value = "/allAddresses",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Address Stored in database without responseMessages")
    public ResponseEntity<List<AddressResponseDto>> fetchAllAddress()
    {
        AddressLogger.info("Get All Address Stored in database");
        List<AddressResponseDto> addressResponseListResponseEntityStatement = new ArrayList<>();
        HttpStatus addressListResponseStatus = HttpStatus.OK;
        try
        {
            AddressLogger.info("invoking addressService.getAllAddress() service");
            addressResponseListResponseEntityStatement = addressService.fetchAllAddress();
            addressListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            AddressLogger.error("Error in get all address : ",errorMessage);
            addressListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(addressListResponseStatus).body(addressResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/singleAddress/{addressId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Address For given Id Stored in database without responseMessages")
    public ResponseEntity<AddressResponseDto> getSingleAddress(@PathVariable Long addressId)
    {
        AddressLogger.info("Get Address For given Id Stored in database");
        AddressResponseDto addressResponseSingleResponse = new AddressResponseDto();
        HttpStatus addressResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            AddressLogger.info("invoking addressService.getAddressById(addressId) service");
            addressResponseSingleResponse = addressService.getSingleAddress(addressId);
            addressResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            AddressLogger.error("Error in get single address : ",errorMessage);
            addressResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(addressResponseSingleResponseStatus).body(addressResponseSingleResponse);
    }
}
