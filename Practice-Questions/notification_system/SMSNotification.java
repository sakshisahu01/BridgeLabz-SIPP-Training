package com.notification_system;

public class SMSNotification implements Notification {
	private String phoneNumber;
	private String message;

	public SMSNotification(String phoneNumber, String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	@Override
	public void send() {
		System.out.println("📧 Sending SMS to " + phoneNumber + ": " + message);

	}

}
