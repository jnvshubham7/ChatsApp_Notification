package com.shubham.ChatsApp_Notification.controller;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody NotificationRequest request) {
        try {
            Message message = Message.builder()
                    .setToken(request.getRecipientToken())
                    .setNotification(new Notification("Hello", request.getText()))
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            return "Message sent: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending message: " + e.getMessage();
        }
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
