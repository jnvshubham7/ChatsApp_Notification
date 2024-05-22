// src/main/java/com/shubham/ChatsApp_Notification/service/NotificationService.java
package com.shubham.ChatsApp_Notification.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String token, String title, String body) throws Exception {
        Message message = Message.builder()
            .putData("title", title)
            .putData("body", body)
            .setToken(token)
            .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);
    }
}
