package com.springboot.microservices.studentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "studentRollNumber")
    private Long studentRollNumber;
    @Column(name = "studentContactNumber")
    private String studentContactNumber;
    @Column(name = "studentEmailAddress")
    private String studentEmailAddress;
    @Column(name = "studentGender")
    private String studentGender;
    @Column(name = "addressId")
    private Long addressId;

    public Student() {}

    public Student(Long studentId, String studentName, Long studentRollNumber, String studentContactNumber, String studentEmailAddress, String studentGender,Long addressId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentContactNumber = studentContactNumber;
        this.studentEmailAddress = studentEmailAddress;
        this.studentGender = studentGender;
        this.addressId = addressId;
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
}
