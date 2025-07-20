package com.notification_system;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {
	private Queue<Notification> queue;
	
	public NotificationQueue() {
		queue = new LinkedList<>();
	}
	
    // Abstraction: Only this method exposed
	public void add(Notification notification) {
        queue.add(notification);
    }

    // Abstraction: Only this method exposed
    public void sendAll() {
        while (!queue.isEmpty()) {
            Notification notification = queue.poll();
            notification.send();
        }
    }
	
}
