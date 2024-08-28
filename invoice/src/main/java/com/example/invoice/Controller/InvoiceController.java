package com.example.invoice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.invoice.Entity.Invoice;
import com.example.invoice.Service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{customerId}")
    public List<Invoice> getInvoices(@PathVariable Long customerId) {
        return invoiceService.getInvoices(customerId);
    }

    @PostMapping
    public Invoice generateInvoice(@RequestBody Invoice invoiceData) {
        return invoiceService.generateInvoice(invoiceData);
    }

    @PutMapping("/{id}/{customerId}")
    public Invoice updateInvoice(@PathVariable Long id, @PathVariable Long customerId, @RequestBody Invoice invoiceData) {
        return invoiceService.updateInvoice(id, customerId, invoiceData);
    }

    @DeleteMapping("/{id}/{customerId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id, @PathVariable Long customerId) {
        invoiceService.deleteInvoice(id, customerId);
        return ResponseEntity.noContent().build();
    }
}