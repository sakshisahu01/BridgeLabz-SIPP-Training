package Inheritance;

class Order{
    int order_id;
    int orderDate;

    Order(int order_id, int orderDate){
        this.order_id = order_id;
        this.orderDate = orderDate;
    }
    void displayinfo(){
        System.out.println("Order ID: " + order_id);
        System.out.println("Order Date: " + orderDate);
    }
}
class ShipperOrder extends Order{
    int trackingNumber;;

    ShipperOrder(int order_id, int orderDate,int trackingNumber){
        super(order_id, orderDate);
        this.trackingNumber = trackingNumber;
    }
    void displayinfo(){
        super.displayinfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShipperOrder{
    int deliveryDate;

    DeliveredOrder(int order_id, int orderDate, int trackingNumber, int deliveryDate){
        super(order_id, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    void displayinfo(){
        super.displayinfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }   
}

public class OnlineRetailOrderManagement {

    public static void main(String[] args){
        DeliveredOrder order = new DeliveredOrder(12345, 20231001, 987654321, 20231005);
        order.displayinfo();
        
    }
    
}
