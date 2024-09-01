package com.example.paymentprocessing.repository;

import com.example.paymentprocessing.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
