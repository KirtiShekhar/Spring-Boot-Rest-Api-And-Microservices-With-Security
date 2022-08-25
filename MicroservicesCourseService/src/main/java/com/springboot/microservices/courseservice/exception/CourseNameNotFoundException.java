package com.springboot.microservices.courseservice.exception;

public class CourseNameNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public CourseNameNotFoundException(String message)
    {
        super(message);
    }

}