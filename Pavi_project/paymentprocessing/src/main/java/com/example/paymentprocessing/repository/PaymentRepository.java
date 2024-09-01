package com.example.paymentprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.example.paymentprocessing.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
