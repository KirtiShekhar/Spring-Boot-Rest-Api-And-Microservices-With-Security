package com.springboot.microservices.studentservice.service.serviceImplementation;

import com.springboot.microservices.studentservice.dto.StudentCourseAddressListOfResponse;
import com.springboot.microservices.studentservice.feignClientService.AddressFeignClient;
import com.springboot.microservices.studentservice.feignClientService.CourseFeignClient;
import com.springboot.microservices.studentservice.repository.StudentRepository;
import com.springboot.microservices.studentservice.service.StudentCommonService;
import com.springboot.microservices.studentservice.service.serviceImplementation.StudentCommonServiceImplementation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentCommonServiceImplementation implements StudentCommonService
{
    @Autowired
    AddressFeignClient addressFeignClient;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    StudentRepository studentRepository;

    Logger studentCourseAddressCircuitBreakerLogger = LoggerFactory.getLogger(StudentCommonServiceImplementation.class);

    long otherServiceCallCount = 1;

    @CircuitBreaker(name="microserviceAddressService",fallbackMethod = "fallbackGetListOfStudentAddressAndCourse")
    @Override
    public List<StudentCourseAddressListOfResponse> getListOfStudentAddressAndCourse()
    {
        List<StudentCourseAddressListOfResponse> studentCourseAddressResponseList = new ArrayList<>();
        Iterator studentsIterator = studentRepository.findAll().iterator();
        while(studentsIterator.hasNext())
        {
            StudentCourseAddressListOfResponse studentCourseAddressListResponseDto = new StudentCourseAddressListOfResponse();
            BeanUtils.copyProperties(studentsIterator.next(),studentCourseAddressListResponseDto);
            studentCourseAddressListResponseDto.setListAddressResponse(addressFeignClient.fetchAllAddress());
            studentCourseAddressListResponseDto.setListCourseResponse(courseFeignClient.fetchAllCourse());
            studentCourseAddressResponseList.add(studentCourseAddressListResponseDto);
        }
        studentCourseAddressCircuitBreakerLogger.info("Number of times Address and Course Service called : " + otherServiceCallCount);
        otherServiceCallCount++;
        return studentCourseAddressResponseList;
    }

    public List<StudentCourseAddressListOfResponse> fallbackGetListOfStudentAddressAndCourse(Throwable scath)
    {
        List<StudentCourseAddressListOfResponse> studentCourseAddressResponseList = new ArrayList<>();
        studentCourseAddressCircuitBreakerLogger.error("Error : " + scath);
        return studentCourseAddressResponseList;
    }
}
