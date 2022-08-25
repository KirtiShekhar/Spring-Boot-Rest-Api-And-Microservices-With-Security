package com.springboot.microservices.courseservice.dto;

public class CourseInsertResponseDto
{
    private Long courseId;
    private String courseName;
    private String courseCategory;
    private String insertMessage;

    public CourseInsertResponseDto(){}

    public CourseInsertResponseDto(Long courseId, String courseName, String courseCategory, String insertMessage) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCategory = courseCategory;
        this.insertMessage = insertMessage;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getInsertMessage() {
        return insertMessage;
    }

    public void setInsertMessage(String insertMessage) {
        this.insertMessage = insertMessage;
    }
}
