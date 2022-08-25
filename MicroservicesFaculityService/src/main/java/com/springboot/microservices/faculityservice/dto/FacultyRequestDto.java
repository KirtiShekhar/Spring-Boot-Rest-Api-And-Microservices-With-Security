package com.springboot.microservices.faculityservice.dto;

import javax.validation.constraints.NotNull;

public class FacultyRequestDto
{
    @NotNull(message = "facultyName Should not be Empty or blank")
    private String facultyName;
    @NotNull(message = "facultyCode Should not be Empty or blank")
    private Long facultyCode;
    @NotNull(message = "facultyContactNumber Should not be Empty or blank")
    private String facultyContactNumber;
    @NotNull(message = "facultyEmailAddress Should not be Empty or blank")
    private String facultyEmailAddress;
    @NotNull(message = "facultyGender Should not be Empty or blank")
    private String facultyGender;
    @NotNull(message = "courseId Should not be Empty or blank")
    private Long courseId;

    public FacultyRequestDto() {}

    public FacultyRequestDto(String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId) {
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
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
}
