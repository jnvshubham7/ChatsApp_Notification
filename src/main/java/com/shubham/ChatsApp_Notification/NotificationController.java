
package com.shubham.ChatsApp_Notification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Add missing import statement
import com.shubham.ChatsApp_Notification.FCMNotificationSender;

@RestController
public class NotificationController {

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationRequest request) {
        try {
            FCMNotificationSender.sendNotification(request.getToken(), request.getTitle(), request.getBody());
        } catch (Exception e) {
            e.printStackTrace();
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
}
