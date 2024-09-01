package com.example.paymentprocessing.controller;

import com.example.paymentprocessing.model.Payment;
import com.example.paymentprocessing.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getPaymentDetails(@PathVariable Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
