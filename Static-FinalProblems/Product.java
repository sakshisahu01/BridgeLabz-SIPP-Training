class Product {
    // Static variable shared by all product instances
    static double discount = 10.0; // Default discount in percentage

    // Final variable: productID cannot be changed once assigned
    private final int productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this' to resolve ambiguity
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update the discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to calculate total price after applying discount
    public double calculateTotalPrice() {
        double total = price * quantity;
        double discountAmount = total * (discount / 100);
        return total - discountAmount;
    }

    // Display product details
    public void displayDetails() {
        System.out.println("Product ID     : " + productID);
        System.out.println("Product Name   : " + productName);
        System.out.println("Unit Price     : ₹" + price);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Discount       : " + discount + "%");
        System.out.println("Total Price    : ₹" + calculateTotalPrice());
    }
}

// Main class to test the Product class
public class Main {
    public static void main(String[] args) {
        // Creating product objects
        Product product1 = new Product(1001, "Wireless Mouse", 750.00, 2);
        Product product2 = new Product(1002, "Bluetooth Headphones", 1500.00, 1);

        // Displaying details before discount update
        System.out.println("=== Product 1 Details ===");
        product1.displayDetails();
        System.out.println();

        System.out.println("=== Product 2 Details ===");
        product2.displayDetails();
        System.out.println();

        // Updating discount using static method
        Product.updateDiscount(15.0); // Change discount to 15%

        // Displaying details after discount update
        System.out.println("=== After Updating Discount ===");
        product1.displayDetails();
        System.out.println();
        product2.displayDetails();
    }
}
