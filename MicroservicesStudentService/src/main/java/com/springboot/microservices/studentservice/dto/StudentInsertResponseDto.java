package com.springboot.microservices.studentservice.dto;

public class StudentInsertResponseDto 
{
    private Long studentId;
    private String studentName;
    private Long studentRollNumber;
    private String studentContactNumber;
    private String studentEmailAddress;
    private String studentGender;
    private Long addressId;
    private String insertMessage;

    public StudentInsertResponseDto() {}

    public StudentInsertResponseDto(Long studentId, String studentName, Long studentRollNumber, String studentContactNumber, String studentEmailAddress, String studentGender, Long addressId, String insertMessage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentContactNumber = studentContactNumber;
        this.studentEmailAddress = studentEmailAddress;
        this.studentGender = studentGender;
        this.addressId = addressId;
        this.insertMessage = insertMessage;
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

    public String getInsertMessage() {
        return insertMessage;
    }

    public void setInsertMessage(String insertMessage) {
        this.insertMessage = insertMessage;
    }
}
