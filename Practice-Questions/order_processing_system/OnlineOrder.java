package com.order_processing_system;

public class OnlineOrder implements IOrder {
	private String orderId;

	public OnlineOrder(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public void process() {
		System.out.println("Processing online order: " + orderId);
	}

}
