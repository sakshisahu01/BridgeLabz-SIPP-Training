package com.order_processing_system;

public class SubscriptionOrder implements IOrder{
	private String planType;

	public SubscriptionOrder(String planType) {
		this.planType = planType;
	}

	@Override
	public void process() {
        System.out.println("Processing subscription order: " + planType);
	}

}
