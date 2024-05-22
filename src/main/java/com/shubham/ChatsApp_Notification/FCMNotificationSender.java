package com.shubham.ChatsApp_Notification;

import com.google.gson.Gson;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FCMNotificationSender {

    private static final String SERVER_KEY = "AAAA0z2eAHs:APA91bEhUzjy-PvcFSZjmq82YiRzsvS60lSqFnEZs34iS3jVm0xInu7Xf8aWksnXORA9JFCLmiD8pB0kbIN8Zv1c0i5WBq0B_QBgaeD8UzqjTmKI0iTHSeubne-FemVVrrWKqCO8A6z5";
    private static final String FCM_URL = "https://fcm.googleapis.com/fcm/send";

    public static void sendNotification(String userDeviceToken, String title, String body) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(FCM_URL);
            httpPost.setHeader("Authorization", "key=" + SERVER_KEY);
            httpPost.setHeader("Content-Type", "application/json");

            String notificationJson = createNotificationJson(userDeviceToken, title, body);
            httpPost.setEntity(new StringEntity(notificationJson));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                if (response.getCode() != 200) {
                    throw new HttpResponseException(response.getCode(), "Failed to send notification");
                }
            }
        }
    }

    private static String createNotificationJson(String userDeviceToken, String title, String body) {
        Map<String, Object> notificationMessage = new HashMap<>();
        notificationMessage.put("to", userDeviceToken);

        Map<String, String> notification = new HashMap<>();
        notification.put("title", title);
        notification.put("body", body);

        notificationMessage.put("notification", notification);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");

        notificationMessage.put("data", data);

        return new Gson().toJson(notificationMessage);
    }

    public static void main(String[] args) {
        try {
            sendNotification("USER_DEVICE_TOKEN", "New Message", "You have received a new message");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

