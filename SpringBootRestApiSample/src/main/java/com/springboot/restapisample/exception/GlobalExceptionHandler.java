package com.springboot.restapisample.exception;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> hanldeException(MethodArgumentNotValidException ex)
    {
        List<FieldError> errors=ex.getFieldErrors();
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        validationErrorResponse.setErrorDateTime(LocalDateTime.now());
        validationErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        validationErrorResponse.setMessage("Input Data has some errors... Please Input proper data");

        for(FieldError fieldError : errors)
        {
            validationErrorResponse.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> hanldeException(ConstraintViolationException ex)
    {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        validationErrorResponse.setErrorDateTime(LocalDateTime.now());
        validationErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        validationErrorResponse.setMessage("Input Data has some errors... Please Input proper data");
        ex.getConstraintViolations() . forEach(error ->{
            validationErrorResponse.getErrors().put("field",error.getMessage());
        });
        return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNameNotFoundError(NameNotFoundException nnfe)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(nnfe.getMessage());
        //"Product With Given Name Already Exist"
        errorResponse.setStatusCode(HttpStatus.ALREADY_REPORTED.value());
        errorResponse.setErrorDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException pnfe)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(pnfe.getMessage());
        //"Product With Given Name Already Exist"
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductListEmptyException.class)
    public ResponseEntity<ErrorResponse> handleProductListEmpty(ProductListEmptyException plee)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(plee.getMessage());
        //"Product With Given Name Already Exist"
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorDateTime(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
