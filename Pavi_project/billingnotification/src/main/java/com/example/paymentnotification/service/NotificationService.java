package com.example.paymentnotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendPaymentNotification(String recipientEmail, String paymentId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Payment Notification");
        message.setText("Payment with ID " + paymentId + " has been processed.");
        mailSender.send(message);
    }
}
