package com.order_processing_system;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueueManager {
	private Queue<IOrder> orderQueue;

	public OrderQueueManager() {
		this.orderQueue = new LinkedList<>();
	}
	
	public void addOrder(IOrder order) {
		orderQueue.add(order);
	}
	
	public void processAllOrders() {
		while(!orderQueue.isEmpty()) {
			IOrder order = orderQueue.poll();
			order.process();
		}
	}
	
}
