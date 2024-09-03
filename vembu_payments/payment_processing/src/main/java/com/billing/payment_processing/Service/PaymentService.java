package com.billing.payment_processing.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billing.payment_processing.Entity.Payment;
import com.billing.payment_processing.Repository.PaymentRepository;
import com.billing.payment_processing.dto.BillingDTO;
import com.billing.payment_processing.dto.CustomerDTO;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${billing.service.url}")
    private String billingServiceUrl;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    public Payment processPayment(Payment payment) {
        // Fetch billing details to verify the payment amount
        BillingDTO billing = fetchBillingDetails(payment.getId());
        if (billing != null && billing.getAmount().compareTo(payment.getAmount()) == 0) {
            payment.setStatus("INITIATED");
            payment.setTimestamp(LocalDateTime.now());
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Billing amount mismatch or billing details not found");
        }
    }

    public Payment getPayment(Long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        if (payment.isPresent()) {
            return payment.get();
        } else {
            throw new RuntimeException("Payment not found for ID: " + paymentId);
        }
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public BillingDTO fetchBillingDetails(Long billingId) {
        String url = String.format("%s/api/billings/%d", billingServiceUrl, billingId);
        logger.info("Fetching billing details from URL: {}", url);
        try {
            ResponseEntity<BillingDTO> response = restTemplate.getForEntity(url, BillingDTO.class);
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error fetching billing details", e);
            throw new RuntimeException("Error fetching billing details", e);
        }
    }

    private CustomerDTO fetchCustomerById(String customerId) {
        String url = String.format("%s/customers/%s", customerServiceUrl, customerId);
        logger.info("Fetching customer details from URL: {}", url);
        try {
            ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(url, CustomerDTO.class);
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error fetching customer details", e);
            throw new RuntimeException("Error fetching customer details", e);
        }
    }

    public CustomerDTO getCustomerDetails(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerDetails'");
    }

    public Payment initiatePayment(Long billingId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initiatePayment'");
    }
}
