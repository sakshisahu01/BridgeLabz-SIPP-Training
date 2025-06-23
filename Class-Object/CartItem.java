import java.util.ArrayList;
import java.util.Iterator;

// Class to represent each item in the cart
class CartItem {
    // Private fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to calculate total price for this item
    public double getTotalPrice() {
        return price * quantity;
    }

    // Display item details
    public void displayItem() {
        System.out.println(itemName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalPrice());
    }
}

// Class to simulate the cart
class ShoppingCart {
    // List to hold cart items
    private ArrayList<CartItem> cart;

    // Constructor
    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    // Method to add an item to the cart
    public void addItem(CartItem item) {
        cart.add(item);
        System.out.println(item.getItemName() + " added to the cart.");
    }

    // Method to remove an item by name
    public void removeItem(String itemName) {
        Iterator<CartItem> iterator = cart.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                System.out.println(itemName + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in the cart.");
        }
    }

    // Method to display total cost
    public void displayTotalCost() {
        double total = 0;
        System.out.println("\nCart Items:");
        for (CartItem item : cart) {
            item.displayItem();
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: ₹" + total);
    }
}

// Main class to test the program
public class ShoppingCartSimulator {
    public static void main(String[] args) {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items
        cart.addItem(new CartItem("Laptop", 50000, 1));
        cart.addItem(new CartItem("Mouse", 600, 2));
        cart.addItem(new CartItem("Keyboard", 1200, 1));

        // Display total cost
        cart.displayTotalCost();

        // Remove an item
        cart.removeItem("Mouse");

        // Display total after removal
        cart.displayTotalCost();
    }
}
