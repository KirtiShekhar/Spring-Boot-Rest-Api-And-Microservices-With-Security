package com.springboot.microservices.faculityservice.dto;

import com.springboot.microservices.faculityservice.feignClientResponse.AddressResponseDto;
import com.springboot.microservices.faculityservice.feignClientResponse.CourseResponseDto;
import com.springboot.microservices.faculityservice.response.ResponseMessages;
import org.springframework.http.ResponseEntity;

public class FacultyDetailResponseDto
{
    private Long facultyId;
    private String facultyName;
    private Long facultyCode;
    private String facultyContactNumber;
    private String facultyEmailAddress;
    private String facultyGender;
    private Long courseId;
    private ResponseEntity<ResponseMessages<AddressResponseDto>> addressResponse;
    private ResponseEntity<ResponseMessages<CourseResponseDto>> courseResponse;

    public FacultyDetailResponseDto() {}

    public FacultyDetailResponseDto(Long facultyId, String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId, ResponseEntity<ResponseMessages<AddressResponseDto>> addressResponse, ResponseEntity<ResponseMessages<CourseResponseDto>> courseResponse) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
        this.addressResponse = addressResponse;
        this.courseResponse = courseResponse;
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

    public ResponseEntity<ResponseMessages<AddressResponseDto>> getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(ResponseEntity<ResponseMessages<AddressResponseDto>> addressResponse) {
        this.addressResponse = addressResponse;
    }

    public ResponseEntity<ResponseMessages<CourseResponseDto>> getCourseResponse() {
        return courseResponse;
    }

    public void setCourseResponse(ResponseEntity<ResponseMessages<CourseResponseDto>> courseResponse) {
        this.courseResponse = courseResponse;
    }
}
