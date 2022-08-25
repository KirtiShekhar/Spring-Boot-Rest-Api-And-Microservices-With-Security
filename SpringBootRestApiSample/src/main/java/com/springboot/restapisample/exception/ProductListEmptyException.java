package com.springboot.restapisample.exception;

public class ProductListEmptyException extends RuntimeException
{

    private static final long serialVersionUID=1L;

    public ProductListEmptyException(String message)
    {
        super(message);
    }

}