package com.springboot.microservices.courseservice.dto;

import javax.validation.constraints.NotNull;

public class CourseRequestDto
{
    @NotNull(message = "courseName Should not be Empty or blank")
    private String courseName;
    @NotNull(message = "courseCategory Should not be Empty or blank")
    private String courseCategory;

    public CourseRequestDto(){}

    public CourseRequestDto(String courseName, String courseCategory) {
        this.courseName = courseName;
        this.courseCategory = courseCategory;
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
}
