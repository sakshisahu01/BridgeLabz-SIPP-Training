package com.order_processing_system;

public class OfflineOrder implements IOrder {
	private String customerName;

	public OfflineOrder(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public void process() {
		System.out.println("Processing Offline order for: " + customerName);

	}

}
