package com.example.billinghistory.controller;

import com.example.billinghistory.model.Billing;
import com.example.billinghistory.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingRepository billingRepository;

    public BillingController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @GetMapping("/history/{customerId}")
    public List<Billing> getBillingHistory(@PathVariable Long customerId) {
        return billingRepository.findByCustomerId(customerId);
    }
}
