package com.springboot.microservices.studentservice.exception;

public class StudentNameNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public StudentNameNotFoundException(String message)
    {
        super(message);
    }

}