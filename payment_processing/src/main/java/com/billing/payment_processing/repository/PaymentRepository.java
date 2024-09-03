package com.billing.payment_processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.payment_processing.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(String orderId);
}

