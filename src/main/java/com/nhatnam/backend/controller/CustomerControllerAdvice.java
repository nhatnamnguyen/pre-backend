package com.nhatnam.backend.controller;

import com.nhatnam.backend.exception.CustomerNoFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(CustomerNoFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleCustomerNoFoundException(CustomerNoFoundException e) {
        return "Customer " + e.getCustomerId() + " not found.";
    }
}
