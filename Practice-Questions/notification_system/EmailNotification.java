package com.notification_system;

public class EmailNotification implements Notification {
	private String email;
	private String message;

	public EmailNotification(String email, String message) {
		this.email = email;
		this.message = message;
	}

	@Override
	public void send() {
		System.out.println("📧 Sending Email to " + email + ": " + message);
	}

}
