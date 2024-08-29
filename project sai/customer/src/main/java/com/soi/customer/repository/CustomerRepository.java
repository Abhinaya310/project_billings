package com.soi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soi.customer.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



  

}
