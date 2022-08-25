package com.springboot.microservices.studentservice.dto;

import com.springboot.microservices.studentservice.feignClientResponse.AddressResponseDto;
import com.springboot.microservices.studentservice.feignClientResponse.CourseResponseDto;
import org.springframework.http.ResponseEntity;

public class StudentCourseAddressSingleResponse
{
    private Long studentId;
    private String studentName;
    private Long studentRollNumber;
    private String studentContactNumber;
    private String studentEmailAddress;
    private String studentGender;
    private Long addressId;
    private ResponseEntity<AddressResponseDto> addressSingleResponse;
    private ResponseEntity<CourseResponseDto> courseSingleResponse;

    public StudentCourseAddressSingleResponse() {}

    public StudentCourseAddressSingleResponse(Long studentId, String studentName, Long studentRollNumber, String studentContactNumber, String studentEmailAddress, String studentGender, Long addressId, ResponseEntity<AddressResponseDto> addressSingleResponse, ResponseEntity<CourseResponseDto> courseSingleResponse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentContactNumber = studentContactNumber;
        this.studentEmailAddress = studentEmailAddress;
        this.studentGender = studentGender;
        this.addressId = addressId;
        this.addressSingleResponse = addressSingleResponse;
        this.courseSingleResponse = courseSingleResponse;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(Long studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentContactNumber() {
        return studentContactNumber;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
