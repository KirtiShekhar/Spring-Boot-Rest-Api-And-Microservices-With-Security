package com.springboot.microservices.courseservice.service.serviceImplementation;

import com.springboot.microservices.courseservice.dto.CourseInsertResponseDto;
import com.springboot.microservices.courseservice.dto.CourseRequestDto;
import com.springboot.microservices.courseservice.dto.CourseResponseDto;
import com.springboot.microservices.courseservice.entity.Course;
import com.springboot.microservices.courseservice.exception.CourseNameNotFoundException;
import com.springboot.microservices.courseservice.exception.CourseNotFoundException;
import com.springboot.microservices.courseservice.repository.CourseRepository;
import com.springboot.microservices.courseservice.response.ResponseMessages;
import com.springboot.microservices.courseservice.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService
{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseMessages<CourseInsertResponseDto> insertCourse(@Valid CourseRequestDto courseRequestDto)
    {
        ResponseMessages<CourseInsertResponseDto> courseSaveResponseStatement = new ResponseMessages<>();
        CourseInsertResponseDto courseSaveResponseDto = new CourseInsertResponseDto();
        Course courseName = courseRepository.findByCourseName(courseRequestDto.getCourseName());
        if(courseName != null)
        {
            throw new CourseNameNotFoundException("Course with given name already exist , please check....");
        }
        Course course = new Course();
        BeanUtils.copyProperties(courseRequestDto,course);
        Course savedCourse = courseRepository.saveAndFlush(course);
        BeanUtils.copyProperties(course,courseSaveResponseDto);
        if(savedCourse != null)
        {
            courseSaveResponseDto.setInsertMessage("New Course Saved Successfully");
        }
        else
        {
            courseSaveResponseDto.setInsertMessage("New Course Not Saved Successfully");
        }
        courseSaveResponseStatement.setData(courseSaveResponseDto);
        return courseSaveResponseStatement;
    }

    @Override
    public ResponseMessages<List<CourseResponseDto>> getAllCourse()
    {
        ResponseMessages<List<CourseResponseDto>> courseResponseListAllStatements = new ResponseMessages<>();
        List<CourseResponseDto> courseResponseList = new ArrayList<>();
        Iterator courseIterator = courseRepository.findAll().iterator();
        while(courseIterator.hasNext())
        {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            BeanUtils.copyProperties(courseIterator.next(),courseResponseDto);
            courseResponseList.add(courseResponseDto);
        }
        courseResponseListAllStatements.setData(courseResponseList);
        return courseResponseListAllStatements;
    }

    @Override
    public ResponseMessages<CourseResponseDto> getCourseById(Long courseId)
    {
        ResponseMessages<CourseResponseDto> courseResponseStatement = new ResponseMessages<>();
        Course course;
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        Optional<Course> existCourse = courseRepository.findById(courseId);
        if(existCourse.isPresent())
        {
            course = existCourse.get();
            BeanUtils.copyProperties(course,courseResponseDto);
        }
        else
        {
            throw new CourseNotFoundException("Course with given id not exist");
        }
        courseResponseStatement.setData(courseResponseDto);
        return courseResponseStatement;
    }

    @Override
    public List<CourseResponseDto> fetchAllCourse()
    {
        List<CourseResponseDto> courseResponseList = new ArrayList<>();
        Iterator courseIterator = courseRepository.findAll().iterator();
        while(courseIterator.hasNext())
        {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            BeanUtils.copyProperties(courseIterator.next(),courseResponseDto);
            courseResponseList.add(courseResponseDto);
        }
        return courseResponseList;
    }

    @Override
    public CourseResponseDto getSingleCourse(Long courseId)
    {
        Course course;
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        Optional<Course> existCourse = courseRepository.findById(courseId);
        if(existCourse.isPresent())
        {
            course = existCourse.get();
            BeanUtils.copyProperties(course,courseResponseDto);
        }
        else
        {
            throw new CourseNotFoundException("Course with given id not exist");
        }
        return courseResponseDto;
    }
}
