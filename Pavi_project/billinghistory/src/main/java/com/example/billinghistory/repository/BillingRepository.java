package com.example.billinghistory.repository;

import com.example.billinghistory.model.BillingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<BillingHistory, Long> {
    List<BillingHistory> findByCustomerId(Long customerId);
}
