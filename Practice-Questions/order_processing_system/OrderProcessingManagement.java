package com.order_processing_system;

public class OrderProcessingManagement {
	public static void main(String[] args) {
        OrderQueueManager manager = new OrderQueueManager();

        manager.addOrder(new OnlineOrder("ON123"));
        manager.addOrder(new OfflineOrder("Ravi"));
        manager.addOrder(new SubscriptionOrder("Premium Plan"));

        manager.processAllOrders();
    }
}
