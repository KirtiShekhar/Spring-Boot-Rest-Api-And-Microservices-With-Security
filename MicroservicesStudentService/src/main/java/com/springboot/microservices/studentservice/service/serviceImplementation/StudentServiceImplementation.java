package com.springboot.microservices.studentservice.service.serviceImplementation;

import com.springboot.microservices.studentservice.dto.*;
import com.springboot.microservices.studentservice.entity.Student;
import com.springboot.microservices.studentservice.exception.StudentNameNotFoundException;
import com.springboot.microservices.studentservice.exception.StudentNotFoundException;
import com.springboot.microservices.studentservice.feignClientService.AddressFeignClient;
import com.springboot.microservices.studentservice.feignClientService.CourseFeignClient;
import com.springboot.microservices.studentservice.repository.StudentRepository;
import com.springboot.microservices.studentservice.response.ResponseMessages;
import com.springboot.microservices.studentservice.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
public class StudentServiceImplementation implements StudentService
{
    @Autowired
    AddressFeignClient addressFeignClient;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseMessages<StudentInsertResponseDto> insertStudent(@Valid StudentRequestDto studentRequestDto)
    {
        ResponseMessages<StudentInsertResponseDto> studentSaveResponseStatement = new ResponseMessages<>();
        StudentInsertResponseDto studentSaveResponseDto = new StudentInsertResponseDto();
        Student studentEmailAddress = studentRepository.findByStudentEmailAddress(studentRequestDto.getStudentEmailAddress());
        if(studentEmailAddress != null)
        {
            throw new StudentNameNotFoundException("Student with given name already exist , please check....");
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDto,student);
        Student savedProduct = studentRepository.saveAndFlush(student);
        BeanUtils.copyProperties(student,studentSaveResponseDto);
        if(savedProduct != null)
        {
            studentSaveResponseDto.setInsertMessage("New Student Saved Successfully");
        }
        else
        {
            studentSaveResponseDto.setInsertMessage("New Student Not Saved Successfully");
        }
        studentSaveResponseStatement.setData(studentSaveResponseDto);
        return studentSaveResponseStatement;
    }

    @Override
    public ResponseMessages<List<StudentResponseDto>> getAllStudent()
    {
        ResponseMessages<List<StudentResponseDto>> studentResponseListAllStatements = new ResponseMessages<>();
        List<StudentResponseDto> studentResponseList = new ArrayList<>();
        Iterator studentsIterator = studentRepository.findAll().iterator();
        while(studentsIterator.hasNext())
        {
            StudentResponseDto productResponseDto = new StudentResponseDto();
            BeanUtils.copyProperties(studentsIterator.next(),productResponseDto);
            studentResponseList.add(productResponseDto);
        }
        studentResponseListAllStatements.setData(studentResponseList);
        return studentResponseListAllStatements;
    }

    @Override
    public ResponseMessages<StudentResponseDto> getStudentById(Long studentId)
    {
        ResponseMessages<StudentResponseDto> studentResponseStatement = new ResponseMessages<>();
        Student student;
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Optional<Student> existStudent = studentRepository.findById(studentId);
        if(existStudent.isPresent())
        {
            student = existStudent.get();
            BeanUtils.copyProperties(student,studentResponseDto);
        }
        else
        {
            throw new StudentNotFoundException("Student with given id not exist");
        }
        studentResponseStatement.setData(studentResponseDto);
        return studentResponseStatement;
    }

    @Override
    public ResponseMessages<StudentDetailResponseDto> getStudentWithAddressAndCourse(@PathVariable Long studentId,@PathVariable Long addressId,@PathVariable Long courseId)
    {
        ResponseMessages<StudentDetailResponseDto> studentDetailResponseStatement = new ResponseMessages<>();
        Student student;
        StudentDetailResponseDto studentDetailResponseDto = new StudentDetailResponseDto();
        Optional<Student> existStudent = studentRepository.findById(studentId);
        if(existStudent.isPresent())
        {
            student = existStudent.get();
            BeanUtils.copyProperties(student,studentDetailResponseDto);
            studentDetailResponseDto.setAddressResponse(addressFeignClient.getAddress(addressId));
            studentDetailResponseDto.setCourseResponse(courseFeignClient.getCourse(courseId));
        }
        else
        {
            throw new StudentNotFoundException("Student with given id not exist");
        }
        studentDetailResponseStatement.setData(studentDetailResponseDto);
        return studentDetailResponseStatement;
    }

    @Override
    public List<StudentResponseDto> fetchAllStudent()
    {
        List<StudentResponseDto> studentResponseList = new ArrayList<>();
        Iterator studentsIterator = studentRepository.findAll().iterator();
        while(studentsIterator.hasNext())
        {
            StudentResponseDto productResponseDto = new StudentResponseDto();
            BeanUtils.copyProperties(studentsIterator.next(),productResponseDto);
            studentResponseList.add(productResponseDto);
        }
        return studentResponseList;
    }

    @Override
    public StudentResponseDto getSingleStudent(Long studentId)
    {
        Student student;
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Optional<Student> existStudent = studentRepository.findById(studentId);
        if(existStudent.isPresent())
        {
            student = existStudent.get();
            BeanUtils.copyProperties(student,studentResponseDto);
        }
        else
        {
            throw new StudentNotFoundException("Student with given id not exist");
        }
        return studentResponseDto;
    }

    @Override
    public StudentCourseAddressSingleResponse getSingleStudentAddressAndCourse(@PathVariable Long studentId, @PathVariable Long addressId, @PathVariable Long courseId)
    {
        Student student;
        StudentCourseAddressSingleResponse studentCourseAddressSingleResponseDto = new StudentCourseAddressSingleResponse();
        Optional<Student> existStudent = studentRepository.findById(studentId);
        if(existStudent.isPresent())
        {
            student = existStudent.get();
            BeanUtils.copyProperties(student,studentCourseAddressSingleResponseDto);
            studentCourseAddressSingleResponseDto.setAddressSingleResponse(addressFeignClient.getSingleAddress(addressId));
            studentCourseAddressSingleResponseDto.setCourseSingleResponse(courseFeignClient.getSingleCourse(courseId));
        }
        else
        {
            throw new StudentNotFoundException("Student with given id not exist");
        }
        return studentCourseAddressSingleResponseDto;
    }
}
