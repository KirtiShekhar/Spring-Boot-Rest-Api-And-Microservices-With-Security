package com.springboot.microservices.faculityservice.exception;

public class FacultyNameNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public FacultyNameNotFoundException(String message)
    {
        super(message);
    }

}