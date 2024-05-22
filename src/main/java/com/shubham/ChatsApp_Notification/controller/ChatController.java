// src/main/java/com/shubham/ChatsApp_Notification/controller/ChatController.java
package com.shubham.ChatsApp_Notification.controller;

import com.shubham.ChatsApp_Notification.model.ChatMessage;
import com.shubham.ChatsApp_Notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody ChatMessage message) {
        // Save the message to the database
        // ...

        // Send notification
        try {
            notificationService.sendNotification(message.getRecipientToken(), "New Message", message.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
