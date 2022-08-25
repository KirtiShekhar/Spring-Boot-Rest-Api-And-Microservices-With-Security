package com.springboot.microservices.studentservice.feignClientResponse;

public class CourseResponseDto
{
    private Long courseId;
    private String courseName;
    private String courseCategory;

    public CourseResponseDto(){}

    public CourseResponseDto(Long courseId, String courseName, String courseCategory) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCategory = courseCategory;
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
}
