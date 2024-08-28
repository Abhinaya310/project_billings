package com.example.refundmanagement.controller;
import com.example.refundmanagement.entity.Refund;
import com.example.refundmanagement.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/refunds")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @GetMapping
    public List<Refund> getAllRefunds() {
        return refundService.getAllRefunds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refund> getRefundById(@PathVariable Long id) {
        Optional<Refund> refund = refundService.getRefundById(id);
        return refund.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Refund> createRefund(@RequestBody Refund refund) {
        Refund savedRefund = refundService.saveRefund(refund);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRefund);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRefund(@PathVariable Long id) {
        refundService.deleteRefund(id);
        return ResponseEntity.noContent().build();
    }
}
