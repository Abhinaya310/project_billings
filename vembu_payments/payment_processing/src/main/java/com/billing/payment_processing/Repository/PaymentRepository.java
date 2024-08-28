package com.billing.payment_processing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.payment_processing.Entity.Payment;
@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}


