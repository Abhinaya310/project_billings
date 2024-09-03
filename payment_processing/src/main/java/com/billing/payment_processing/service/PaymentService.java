package com.billing.payment_processing.service;

import org.springframework.stereotype.Service;

import com.billing.payment_processing.dto.PaymentDTO;

@Service
public class PaymentService {

    // @Autowired
    // private FakePaymentGatewayService fakePaymentGatewayService;

    public PaymentDTO initiatePayment(PaymentDTO paymentDTO) {
       // return fakePaymentGatewayService.initiatePayment(paymentDTO);
       return null;
    }

  
}
