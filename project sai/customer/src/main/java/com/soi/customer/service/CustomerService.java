package com.soi.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soi.customer.model.Customer;
import com.soi.customer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        System.out.println("Creating customer with phoneNo: " + customer.getPhoneNo());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        if (customerRepository.existsById(id)) {
            customerDetails.setId(id);
            System.out.println("Updating customer with phoneNo: " + customerDetails.getPhoneNo());
            return customerRepository.save(customerDetails);
        } else {
            throw new ResourceNotFoundException("Customer not found with id " + id);
        }
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer not found with id " + id);
        }
    }
}
