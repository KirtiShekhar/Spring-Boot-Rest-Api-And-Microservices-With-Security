package com.springboot.microservices.faculityservice.service.serviceImplementation;

import com.springboot.microservices.faculityservice.dto.*;
import com.springboot.microservices.faculityservice.entity.Faculty;
import com.springboot.microservices.faculityservice.exception.FacultyNameNotFoundException;
import com.springboot.microservices.faculityservice.exception.FacultyNotFoundException;
import com.springboot.microservices.faculityservice.feignClientService.AddressFeignClient;
import com.springboot.microservices.faculityservice.feignClientService.CourseFeignClient;
import com.springboot.microservices.faculityservice.repository.FacultyRepository;
import com.springboot.microservices.faculityservice.response.ResponseMessages;
import com.springboot.microservices.faculityservice.service.FacultyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImplementation implements FacultyService
{
    @Autowired
    AddressFeignClient addressFeignClient;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public ResponseMessages<FacultyInsertResponseDto> insertFaculty(@Valid FacultyRequestDto facultyRequestDto)
    {
        ResponseMessages<FacultyInsertResponseDto> facultySaveResponseStatement = new ResponseMessages<>();
        FacultyInsertResponseDto facultySaveResponseDto = new FacultyInsertResponseDto();
        Faculty facultyEmailAddress = facultyRepository.findByFacultyEmailAddress(facultyRequestDto.getFacultyEmailAddress());
        if(facultyEmailAddress != null)
        {
            throw new FacultyNameNotFoundException("Faculty with given email Address already exist , please check....");
        }
        Faculty faculty = new Faculty();
        BeanUtils.copyProperties(facultyRequestDto,faculty);
        Faculty savedFaculty = facultyRepository.saveAndFlush(faculty);
        BeanUtils.copyProperties(faculty,facultySaveResponseDto);
        if(savedFaculty != null)
        {
            facultySaveResponseDto.setInsertMessage("New Faculty Saved Successfully");
        }
        else
        {
            facultySaveResponseDto.setInsertMessage("New Faculty Not Saved Successfully");
        }
        facultySaveResponseStatement.setData(facultySaveResponseDto);
        return facultySaveResponseStatement;
    }

    @Override
    public ResponseMessages<List<FacultyResponseDto>> getAllFaculty()
    {
        ResponseMessages<List<FacultyResponseDto>> facultyResponseListAllStatements = new ResponseMessages<>();
        List<FacultyResponseDto> facultyResponseList = new ArrayList<>();
        Iterator facultyIterator = facultyRepository.findAll().iterator();
        while(facultyIterator.hasNext())
        {
            FacultyResponseDto facultyResponseDto = new FacultyResponseDto();
            BeanUtils.copyProperties(facultyIterator.next(),facultyResponseDto);
            facultyResponseList.add(facultyResponseDto);
        }
        facultyResponseListAllStatements.setData(facultyResponseList);
        return facultyResponseListAllStatements;
    }

    @Override
    public ResponseMessages<FacultyResponseDto> getFacultyById(Long facultyId)
    {
        ResponseMessages<FacultyResponseDto> facultyResponseStatement = new ResponseMessages<>();
        Faculty faculty;
        FacultyResponseDto facultyResponseDto = new FacultyResponseDto();
        Optional<Faculty> existFaculty = facultyRepository.findById(facultyId);
        if(existFaculty.isPresent())
        {
            faculty = existFaculty.get();
            BeanUtils.copyProperties(faculty,facultyResponseDto);
        }
        else
        {
            throw new FacultyNotFoundException("Faculty with given id not exist");
        }
        facultyResponseStatement.setData(facultyResponseDto);
        return facultyResponseStatement;
    }

    @Override
    public ResponseMessages<FacultyDetailResponseDto> getFacultyWithAddressAndCourse(@PathVariable Long facultyId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        ResponseMessages<FacultyDetailResponseDto> facultyDetailResponseStatement = new ResponseMessages<>();
        Faculty faculty;
        FacultyDetailResponseDto facultyDetailResponseDto = new FacultyDetailResponseDto();
        Optional<Faculty> existFaculty = facultyRepository.findById(facultyId);
        if(existFaculty.isPresent())
        {
            faculty = existFaculty.get();
            BeanUtils.copyProperties(faculty,facultyDetailResponseDto);
            facultyDetailResponseDto.setAddressResponse(addressFeignClient.getAddress(addressId));
            facultyDetailResponseDto.setCourseResponse(courseFeignClient.getCourse(courseId));
        }
        else
        {
            throw new FacultyNotFoundException("Faculty with given id not exist");
        }
        facultyDetailResponseStatement.setData(facultyDetailResponseDto);
        return facultyDetailResponseStatement;
    }

    @Override
    public List<FacultyResponseDto> fetchAllFaculty()
    {
        List<FacultyResponseDto> facultyResponseList = new ArrayList<>();
        Iterator facultyIterator = facultyRepository.findAll().iterator();
        while(facultyIterator.hasNext())
        {
            FacultyResponseDto facultyResponseDto = new FacultyResponseDto();
            BeanUtils.copyProperties(facultyIterator.next(),facultyResponseDto);
            facultyResponseList.add(facultyResponseDto);
        }
        return facultyResponseList;
    }

    @Override
    public FacultyResponseDto getSingleFaculty(Long facultyId)
    {
        Faculty faculty;
        FacultyResponseDto facultyResponseDto = new FacultyResponseDto();
        Optional<Faculty> existFaculty = facultyRepository.findById(facultyId);
        if(existFaculty.isPresent())
        {
            faculty = existFaculty.get();
            BeanUtils.copyProperties(faculty,facultyResponseDto);
        }
        else
        {
            throw new FacultyNotFoundException("Faculty with given id not exist");
        }
        return facultyResponseDto;
    }

    @Override
    public FacultyCourseAddressSingleResponse getSingleFacultyAddressAndCourse(@PathVariable Long facultyId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        Faculty faculty;
        FacultyCourseAddressSingleResponse facultySingleResponseDto = new FacultyCourseAddressSingleResponse();
        Optional<Faculty> existFaculty = facultyRepository.findById(facultyId);
        if(existFaculty.isPresent())
        {
            faculty = existFaculty.get();
            BeanUtils.copyProperties(faculty,facultySingleResponseDto);
            facultySingleResponseDto.setAddressSingleResponse(addressFeignClient.getSingleAddress(addressId));
            facultySingleResponseDto.setCourseSingleResponse(courseFeignClient.getSingleCourse(courseId));
        }
        else
        {
            throw new FacultyNotFoundException("Faculty with given id not exist");
        }
        return facultySingleResponseDto;
    }

    @Override
    public List<FacultyCourseAddressListOfResponse> getListOfFacultyAddressAndCourse()
    {
        List<FacultyCourseAddressListOfResponse> facultyCourseAddressResponseList = new ArrayList<>();
        Iterator facultyIterator = facultyRepository.findAll().iterator();
        while(facultyIterator.hasNext())
        {
            FacultyCourseAddressListOfResponse facultyListResponse = new FacultyCourseAddressListOfResponse();
            BeanUtils.copyProperties(facultyIterator.next(),facultyListResponse);
            facultyListResponse.setListAddressResponse(addressFeignClient.fetchAllAddress());
            facultyListResponse.setListCourseResponse(courseFeignClient.fetchAllCourse());
            facultyCourseAddressResponseList.add(facultyListResponse);
        }
        return facultyCourseAddressResponseList;
    }
}
