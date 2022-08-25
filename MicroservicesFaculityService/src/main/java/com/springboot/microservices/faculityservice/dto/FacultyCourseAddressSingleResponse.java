package com.springboot.microservices.faculityservice.dto;

import com.springboot.microservices.faculityservice.feignClientResponse.AddressResponseDto;
import com.springboot.microservices.faculityservice.feignClientResponse.CourseResponseDto;
import org.springframework.http.ResponseEntity;

public class FacultyCourseAddressSingleResponse
{
    private Long facultyId;
    private String facultyName;
    private Long facultyCode;
    private String facultyContactNumber;
    private String facultyEmailAddress;
    private String facultyGender;
    private Long courseId;
    private ResponseEntity<AddressResponseDto> addressSingleResponse;
    private ResponseEntity<CourseResponseDto> courseSingleResponse;

    public FacultyCourseAddressSingleResponse() {}

    public FacultyCourseAddressSingleResponse(Long facultyId, String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId, ResponseEntity<AddressResponseDto> addressSingleResponse, ResponseEntity<CourseResponseDto> courseSingleResponse) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
        this.addressSingleResponse = addressSingleResponse;
        this.courseSingleResponse = courseSingleResponse;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Long getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(Long facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyContactNumber() {
        return facultyContactNumber;
    }

    public void setFacultyContactNumber(String facultyContactNumber) {
        this.facultyContactNumber = facultyContactNumber;
    }

    public String getFacultyEmailAddress() {
        return facultyEmailAddress;
    }

    public void setFacultyEmailAddress(String facultyEmailAddress) {
        this.facultyEmailAddress = facultyEmailAddress;
    }

    public String getFacultyGender() {
        return facultyGender;
    }

    public void setFacultyGender(String facultyGender) {
        this.facultyGender = facultyGender;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public ResponseEntity<AddressResponseDto> getAddressSingleResponse() {
        return addressSingleResponse;
    }

    public void setAddressSingleResponse(ResponseEntity<AddressResponseDto> addressSingleResponse) {
        this.addressSingleResponse = addressSingleResponse;
    }

    public ResponseEntity<CourseResponseDto> getCourseSingleResponse() {
        return courseSingleResponse;
    }

    public void setCourseSingleResponse(ResponseEntity<CourseResponseDto> courseSingleResponse) {
        this.courseSingleResponse = courseSingleResponse;
    }
}
