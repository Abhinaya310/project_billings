package com.example.paymentprocessing.controller;

import com.example.paymentprocessing.model.Payment;
import com.example.paymentprocessing.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        payment.setStatus("Processed");
        return paymentRepository.save(payment);
    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getPayment(@PathVariable Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
