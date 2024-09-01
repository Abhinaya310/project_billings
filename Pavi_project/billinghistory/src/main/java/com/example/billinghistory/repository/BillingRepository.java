package com.example.billinghistory.repository;

import com.example.billinghistory.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByCustomerId(Long customerId);
}
