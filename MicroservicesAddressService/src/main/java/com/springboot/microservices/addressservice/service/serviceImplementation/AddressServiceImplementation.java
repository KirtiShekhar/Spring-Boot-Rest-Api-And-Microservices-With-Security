package com.springboot.microservices.addressservice.service.serviceImplementation;

import com.springboot.microservices.addressservice.dto.AddressInsertResponseDto;
import com.springboot.microservices.addressservice.dto.AddressRequestDto;
import com.springboot.microservices.addressservice.dto.AddressResponseDto;
import com.springboot.microservices.addressservice.entity.Address;
import com.springboot.microservices.addressservice.exception.AddressNotFoundException;
import com.springboot.microservices.addressservice.exception.StateNameNotFoundException;
import com.springboot.microservices.addressservice.repository.AddressRepository;
import com.springboot.microservices.addressservice.response.ResponseMessages;
import com.springboot.microservices.addressservice.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService
{
    @Autowired
    AddressRepository addressRepository;

    @Override
    public ResponseMessages<AddressInsertResponseDto> insertAddress(@Valid AddressRequestDto addressRequestDto)
    {
        ResponseMessages<AddressInsertResponseDto> addressSaveResponseStatement = new ResponseMessages<>();
        AddressInsertResponseDto addressSaveResponseDto = new AddressInsertResponseDto();
        Address addressStateName = addressRepository.findByState(addressRequestDto.getState());
        if(addressStateName != null)
        {
            throw new StateNameNotFoundException("State with given name already exist , please check....");
        }
        Address address = new Address();
        BeanUtils.copyProperties(addressRequestDto,address);
        Address savedAddress = addressRepository.saveAndFlush(address);
        BeanUtils.copyProperties(address,addressSaveResponseDto);
        if(savedAddress != null)
        {
            addressSaveResponseDto.setInsertMessage("New Address Saved Successfully");
        }
        else
        {
            addressSaveResponseDto.setInsertMessage("New Address Not Saved Successfully");
        }
        addressSaveResponseStatement.setData(addressSaveResponseDto);
        return addressSaveResponseStatement;
    }

    @Override
    public ResponseMessages<List<AddressResponseDto>> getAllAddress()
    {
        ResponseMessages<List<AddressResponseDto>> addressResponseListAllStatements = new ResponseMessages<>();
        List<AddressResponseDto> addressResponseList = new ArrayList<>();
        Iterator addressIterator = addressRepository.findAll().iterator();
        while(addressIterator.hasNext())
        {
            AddressResponseDto addressResponseDto = new AddressResponseDto();
            BeanUtils.copyProperties(addressIterator.next(),addressResponseDto);
            addressResponseList.add(addressResponseDto);
        }
        addressResponseListAllStatements.setData(addressResponseList);
        return addressResponseListAllStatements;
    }

    @Override
    public ResponseMessages<AddressResponseDto> getAddressById(Long addressId)
    {
        ResponseMessages<AddressResponseDto> addressResponseStatement = new ResponseMessages<>();
        Address address;
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        Optional<Address> existAddress = addressRepository.findById(addressId);
        if(existAddress.isPresent())
        {
            address = existAddress.get();
            BeanUtils.copyProperties(address,addressResponseDto);
        }
        else
        {
            throw new AddressNotFoundException("Address with given id not exist");
        }
        addressResponseStatement.setData(addressResponseDto);
        return addressResponseStatement;
    }

    @Override
    public List<AddressResponseDto> fetchAllAddress()
    {
        List<AddressResponseDto> addressResponseList = new ArrayList<>();
        Iterator addressIterator = addressRepository.findAll().iterator();
        while(addressIterator.hasNext())
        {
            AddressResponseDto addressResponseDto = new AddressResponseDto();
            BeanUtils.copyProperties(addressIterator.next(),addressResponseDto);
            addressResponseList.add(addressResponseDto);
        }
        return addressResponseList;
    }

    @Override
    public AddressResponseDto getSingleAddress(Long addressId)
    {
        Address address;
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        Optional<Address> existAddress = addressRepository.findById(addressId);
        if(existAddress.isPresent())
        {
            address = existAddress.get();
            BeanUtils.copyProperties(address,addressResponseDto);
        }
        else
        {
            throw new AddressNotFoundException("Address with given id not exist");
        }
        return addressResponseDto;
    }
}
