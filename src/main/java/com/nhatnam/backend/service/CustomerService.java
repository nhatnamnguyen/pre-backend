package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Customer;
import com.nhatnam.backend.data.Product;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getCustomer(String customerId);

    Customer addCustomer(String customerName);

    Customer updateCustomer(String customerId, String customerName);

    void deleteCustomer(String customerId);
}
