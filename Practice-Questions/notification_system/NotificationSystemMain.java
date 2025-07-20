package com.notification_system;

public class NotificationSystemMain {
    public static void main(String[] args) {
        NotificationQueue queue = new NotificationQueue();

        queue.add(new EmailNotification("user@example.com", "Welcome to our platform!"));
        queue.add(new SMSNotification("+919876543210", "Your OTP is 123456"));
        queue.add(new PushNotification("Device123", "You have a new message!"));

        System.out.println("🔔 Sending all notifications:");
        queue.sendAll();
    }
}