package com.example.paymentnotification.Controller;

import com.example.paymentnotification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public String sendNotification(@RequestBody String message) {
        notificationService.sendNotification(message);
        return "Notification sent.";
    }
}
