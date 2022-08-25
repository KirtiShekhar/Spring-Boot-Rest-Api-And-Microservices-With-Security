package com.springboot.microservices.faculityservice.exception;

public class FacultyNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public FacultyNotFoundException(String message)
    {
        super(message);
    }

}