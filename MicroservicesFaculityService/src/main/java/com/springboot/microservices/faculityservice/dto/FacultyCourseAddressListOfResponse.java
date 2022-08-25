package com.springboot.microservices.faculityservice.dto;

import com.springboot.microservices.faculityservice.feignClientResponse.AddressResponseDto;
import com.springboot.microservices.faculityservice.feignClientResponse.CourseResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FacultyCourseAddressListOfResponse
{
    private Long facultyId;
    private String facultyName;
    private Long facultyCode;
    private String facultyContactNumber;
    private String facultyEmailAddress;
    private String facultyGender;
    private Long courseId;
    private ResponseEntity<List<AddressResponseDto>> listAddressResponse;
    private ResponseEntity<List<CourseResponseDto>> listCourseResponse;

    public FacultyCourseAddressListOfResponse() {}

    public FacultyCourseAddressListOfResponse(Long facultyId, String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId, ResponseEntity<List<AddressResponseDto>> listAddressResponse, ResponseEntity<List<CourseResponseDto>> listCourseResponse) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
        this.listAddressResponse = listAddressResponse;
        this.listCourseResponse = listCourseResponse;
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

    public ResponseEntity<List<AddressResponseDto>> getListAddressResponse() {
        return listAddressResponse;
    }

    public void setListAddressResponse(ResponseEntity<List<AddressResponseDto>> listAddressResponse) {
        this.listAddressResponse = listAddressResponse;
    }

    public ResponseEntity<List<CourseResponseDto>> getListCourseResponse() {
        return listCourseResponse;
    }

    public void setListCourseResponse(ResponseEntity<List<CourseResponseDto>> listCourseResponse) {
        this.listCourseResponse = listCourseResponse;
    }
}
