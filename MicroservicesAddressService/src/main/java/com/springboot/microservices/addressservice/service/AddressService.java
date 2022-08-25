package com.springboot.microservices.addressservice.service;

import com.springboot.microservices.addressservice.dto.AddressInsertResponseDto;
import com.springboot.microservices.addressservice.dto.AddressRequestDto;
import com.springboot.microservices.addressservice.dto.AddressResponseDto;
import com.springboot.microservices.addressservice.response.ResponseMessages;
import java.util.List;

public interface AddressService
{
    ResponseMessages<AddressInsertResponseDto> insertAddress(AddressRequestDto addressRequestDto);
    ResponseMessages<List<AddressResponseDto>> getAllAddress();
    ResponseMessages<AddressResponseDto> getAddressById(Long addressId);
    List<AddressResponseDto> fetchAllAddress();
    AddressResponseDto getSingleAddress(Long addressId);
}
