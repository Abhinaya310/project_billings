package com.billing.payment_notification.service;


import com.billing.payment_notification.entity.notification;

import com.billing.payment_notification.repository.NotificationRepository;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class notificationservice {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationRepository notificationrepo;

    public void sendNotification(notification request) {
        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getRecipient());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        mailSender.send(message);

        // Save the notification to the database
        notification notify = new notification();
        notify.setRecipient(request.getRecipient());
        notify.setSubject(request.getSubject());
        notify.setMessage(request.getMessage());
        notificationrepo.save(notify);
    }
    public void sendTestNotification() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("test@example.com");
        message.setSubject("Test Notification");
        message.setText("This is a test notification.");
        mailSender.send(message);
    }
}

