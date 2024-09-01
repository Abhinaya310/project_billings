package com.example.paymentnotification.controller;

import com.example.paymentnotification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void sendNotification(@RequestParam String recipientEmail, @RequestParam String paymentId) {
        notificationService.sendPaymentNotification(recipientEmail, paymentId);
    }
}
