// src/main/java/com/shubham/ChatsApp_Notification/model/ChatMessage.java
package com.shubham.ChatsApp_Notification.model;

public class ChatMessage {
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
