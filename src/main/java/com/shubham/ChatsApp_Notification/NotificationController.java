package com.shubham.ChatsApp_Notification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationRequest request) {
        try {
            System.out.println("Received request: " + request);
            FCMNotificationSender.sendNotification(request.getToken(), request.getTitle(), request.getBody());
            System.out.println("Notification sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send notification");
        }
    }
}

class NotificationRequest {
    private String token;
    private String title;
    private String body;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "token='" + token + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
