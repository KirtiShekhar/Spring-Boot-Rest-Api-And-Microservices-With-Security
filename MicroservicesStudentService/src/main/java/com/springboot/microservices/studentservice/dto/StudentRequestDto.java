package com.springboot.microservices.studentservice.dto;

import javax.validation.constraints.NotNull;

public class StudentRequestDto
{
    @NotNull(message = "studentName Should not be Empty or blank")
    private String studentName;
    @NotNull(message = "studentRollNumber Should not be Empty or blank")
    private Long studentRollNumber;
    @NotNull(message = "studentContactNumber Should not be Empty or blank")
    private String studentContactNumber;
    @NotNull(message = "studentEmailAddress Should not be Empty or blank")
    private String studentEmailAddress;
    @NotNull(message = "studentGender Should not be Empty or blank")
    private String studentGender;
    @NotNull(message = "addressId Should not be Empty or blank")
    private Long addressId;

    public StudentRequestDto() {}

    public StudentRequestDto(String studentName,Long studentRollNumber, String studentContactNumber, String studentEmailAddress, String studentGender, Long addressId) {
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentContactNumber = studentContactNumber;
        this.studentEmailAddress = studentEmailAddress;
        this.studentGender = studentGender;
        this.addressId = addressId;
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
}
