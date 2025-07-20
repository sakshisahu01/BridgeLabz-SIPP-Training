package com.notification_system;

public class PushNotification implements Notification {
	private String deviceId;
	private String message;

	public PushNotification(String deviceId, String message) {
		super();
		this.deviceId = deviceId;
		this.message = message;
	}

	@Override
	public void send() {
		System.out.println("🔔 Sending Push Notification to " + deviceId + ": " + message);

	}

}
