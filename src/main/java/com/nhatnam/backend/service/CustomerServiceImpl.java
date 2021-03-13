package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Customer;
import com.nhatnam.backend.exception.CustomerNoFoundException;
import com.nhatnam.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new CustomerNoFoundException(customerId);
        }
    }

    @Override
    public Customer addCustomer(String customerName) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(customerName);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String customerId, String customerName) {
        Optional<Customer> oldCustomer = customerRepository.findById(customerId);
        if (oldCustomer.isPresent()) {
            Customer newCustomer = oldCustomer.get();
            newCustomer.setName(customerName);
            customerRepository.save(newCustomer);
            return newCustomer;
        } else {
            throw new CustomerNoFoundException(customerId);
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
