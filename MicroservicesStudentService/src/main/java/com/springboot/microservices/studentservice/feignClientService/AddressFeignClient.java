package com.springboot.microservices.studentservice.feignClientService;

import com.springboot.microservices.studentservice.feignClientResponse.AddressResponseDto;
import com.springboot.microservices.studentservice.response.ResponseMessages;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "${addressMicroservice.service.url}",value = "addressMicroservice-feign-client")
public interface AddressFeignClient
{
    @GetMapping(value = "/addressService/address/{addressId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseMessages<AddressResponseDto>> getAddress(@PathVariable Long addressId);

    @GetMapping(value = "/addressService/allAddresses",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressResponseDto>> fetchAllAddress();

    @GetMapping(value = "/addressService/singleAddress/{addressId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponseDto> getSingleAddress(@PathVariable Long addressId);
}

