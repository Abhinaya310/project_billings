package com.example.invoice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.invoice.Entity.Invoice;
import com.example.invoice.Repository.InvoiceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices(Long customerId) {
        return invoiceRepository.findByCustomerId(customerId);
    }

    public Invoice generateInvoice(Invoice invoiceData) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(invoiceData.getCustomerId());
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setDueDate(invoiceData.getDueDate());
        invoice.setTotal(invoiceData.getTotal());
        invoice.setStatus("PENDING");
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Long customerId, Invoice invoiceData) {
        Invoice invoice = invoiceRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setDueDate(invoiceData.getDueDate());
        invoice.setTotal(invoiceData.getTotal());
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id, Long customerId) {
        Invoice invoice = invoiceRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }
}