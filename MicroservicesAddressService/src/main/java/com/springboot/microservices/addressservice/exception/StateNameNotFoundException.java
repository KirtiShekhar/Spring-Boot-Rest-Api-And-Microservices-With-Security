package com.springboot.microservices.addressservice.exception;

public class StateNameNotFoundException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public StateNameNotFoundException(String message)
    {
        super(message);
    }

}