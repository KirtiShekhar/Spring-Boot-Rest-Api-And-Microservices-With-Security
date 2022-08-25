package com.springboot.restapisample.exception;

public class NameNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public NameNotFoundException(String message)
    {
        super(message);
    }

}