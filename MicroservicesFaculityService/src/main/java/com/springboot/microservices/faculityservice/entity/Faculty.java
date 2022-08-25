package com.springboot.microservices.faculityservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty")
public class Faculty
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facultyId")
    private Long facultyId;
    @Column(name = "facultyName")
    private String facultyName;
    @Column(name = "facultyCode")
    private Long facultyCode;
    @Column(name = "facultyContactNumber")
    private String facultyContactNumber;
    @Column(name = "facultyEmailAddress")
    private String facultyEmailAddress;
    @Column(name = "facultyGender")
    private String facultyGender;
    @Column(name = "courseId")
    private Long courseId;

    public Faculty() {}

    public Faculty(Long facultyId, String facultyName, Long facultyCode, String facultyContactNumber, String facultyEmailAddress, String facultyGender, Long courseId) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.facultyContactNumber = facultyContactNumber;
        this.facultyEmailAddress = facultyEmailAddress;
        this.facultyGender = facultyGender;
        this.courseId = courseId;
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
}
