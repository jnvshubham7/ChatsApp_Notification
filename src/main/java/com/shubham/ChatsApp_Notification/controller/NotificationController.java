package com.example.notification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        // Implement your logic to send notification here
        System.out.println("Recipient Token: " + notificationRequest.getRecipientToken());
        System.out.println("Message Text: " + notificationRequest.getText());
        // Return response
        return ResponseEntity.ok("Notification sent successfully!");
    }
}

class NotificationRequest {
    private String recipientToken;
    private String text;

    // Getters and Setters

    public String getRecipientToken() {
        return recipientToken;
    }

    public void setRecipientToken(String recipientToken) {
        this.recipientToken = recipientToken;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
