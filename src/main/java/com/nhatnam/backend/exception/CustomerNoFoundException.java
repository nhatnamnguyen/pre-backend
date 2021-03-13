package com.nhatnam.backend.exception;

public class CustomerNoFoundException extends RuntimeException {
    private String customerId;

    public CustomerNoFoundException(String customerId) {
        super("Customer not found");
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
