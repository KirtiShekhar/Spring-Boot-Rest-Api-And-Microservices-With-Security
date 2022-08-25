package com.springboot.microservices.faculityservice.dto;

public class FacultyInsertResponseDto
{
    private Long facultyId;
    private String facultyName;
    private Long facultyCode;
    private String facultyContactNumber;
    private String facultyEmailAddress;
    private String facultyGender;
    private Long courseId;
    private String insertMessage;

    public FacultyInsertResponseDto() {}

    public FacultyInsertResponseDto(Long facultyId, String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId, String insertMessage) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
        this.insertMessage = insertMessage;
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

    public String getInsertMessage() {
        return insertMessage;
    }

    public void setInsertMessage(String insertMessage) {
        this.insertMessage = insertMessage;
    }
}
