package com.dummy.dummybawa.service;


import com.dummy.dummybawa.model.Customer;
import com.dummy.dummybawa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public com.dummy.dummybawa.model.Customer createCustomer(com.dummy.dummybawa.model.Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null; // or throw an exception
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
