package com.example.billinghistory.controller;

import com.example.billinghistory.model.BillingHistory;
import com.example.billinghistory.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing/history")
public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    @GetMapping("/{customerId}")
    public List<BillingHistory> getBillingHistory(@PathVariable Long customerId) {
        return billingRepository.findByCustomerId(customerId);
    }
}
