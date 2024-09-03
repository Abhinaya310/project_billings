package com.billing.payment_processing.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billing.payment_processing.dto.BillingDTO;
import com.billing.payment_processing.dto.CustomerDTO;
import com.billing.payment_processing.dto.NotificationRequest;
import com.billing.payment_processing.dto.PaymentDTO;
import com.billing.payment_processing.entity.Payment;
import com.billing.payment_processing.repository.PaymentRepository;

@Service
public class FakePaymentGatewayService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${billing.service.url}")
    private String billingServiceUrl;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    public PaymentDTO initiatePayment(PaymentDTO paymentDTO) {
        // Fetch billing details to verify the payment amount
        BillingDTO billing = fetchBillingDetails(paymentDTO.getInvoiceId());
        if (billing != null && billing.getAmount().compareTo(paymentDTO.getAmount()) == 0) {
            Payment payment = new Payment();
            payment.setCustomerId(paymentDTO.getCustomerId());
            payment.setInvoiceId(paymentDTO.getInvoiceId());
            payment.setAmount(paymentDTO.getAmount());
            payment.setPaymentStatus("INITIATED");
            payment.setPaymentDate(LocalDateTime.now());
            // Save payment entity
            Payment savedPayment = paymentRepository.save(payment);

            // Simulate a successful payment
            paymentDTO.setPaymentStatus("SUCCESS");
            ((Object) paymentDTO).setPaymentId(UUID.randomUUID().toString()); // Fake payment ID
            paymentDTO.setAmount(paymentDTO.getAmount());

            // Notify customer
            sendNotification(paymentDTO.getInvoiceId(), fetchCustomerById(paymentDTO.getCustomerId()).getEmail());

            return paymentDTO;
        } else {
            throw new RuntimeException("Billing amount mismatch or billing details not found");
        }
    }

    private BillingDTO fetchBillingDetails(Long invoiceId) {
        String url = billingServiceUrl + "/api/billings/" + invoiceId;
        ResponseEntity<BillingDTO> response = restTemplate.getForEntity(url, BillingDTO.class);
        return response.getBody();
    }

    private CustomerDTO fetchCustomerById(Long customerId) {
        String url = customerServiceUrl + "/api/customers/" + customerId;
        ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(url, CustomerDTO.class);
        return response.getBody();
    }

    private void sendNotification(Long invoiceId, String customerEmail) {
        String url = notificationServiceUrl + "/api/notifications/send";
        restTemplate.postForEntity(url, new NotificationRequest(invoiceId, customerEmail), String.class);
    }
}
