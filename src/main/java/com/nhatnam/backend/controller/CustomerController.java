package com.nhatnam.backend.controller;

import com.nhatnam.backend.data.Customer;
import com.nhatnam.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> listCustomer() {
        return customerService.listCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(final @PathVariable("customerId") String customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/customers")
    public Customer addCustomer(final @RequestParam("name") String customerName) {
        return customerService.addCustomer(customerName);
    }

    @PostMapping("/customers/{customerId}")
    public Customer updateCustomer(final @PathVariable("customerId") String customerId, final @RequestParam("name") String customerName) {
        return customerService.updateCustomer(customerId, customerName);
    }

    @DeleteMapping("customers/{customerId}")
    public void deleteCustomer(final @PathVariable("customerId") String customerId) {
        customerService.deleteCustomer(customerId);
    }
}
