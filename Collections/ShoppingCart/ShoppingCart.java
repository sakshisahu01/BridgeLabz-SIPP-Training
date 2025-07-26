package Collections.ShoppingCart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {

    // HashMap to store product prices (productId -> price)
    private Map<String, Double> productPrices;

    // LinkedHashMap to maintain the order of items added (productId -> quantity)
    private Map<String, Integer> itemsInCartLinked;

    // TreeMap to display items sorted by price (Product object -> quantity)
    // Note: TreeMap sorts by key. To sort by price, Product class must implement Comparable<Product>
    // or a custom Comparator must be provided.
    private Map<Product, Integer> itemsInCartTree;

    // A helper map to quickly get Product objects by their ID
    private Map<String, Product> productCatalog;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        itemsInCartLinked = new LinkedHashMap<>();
        itemsInCartTree = new TreeMap<>();
        productCatalog = new HashMap<>();

        // Initialize some product prices (can be loaded from a database/file in a real app)
        productPrices.put("P001", 1200.00);
        productPrices.put("P002", 75.00);
        productPrices.put("P003", 250.00);
        productPrices.put("P004", 300.00);
        productPrices.put("P005", 500.00);
        productPrices.put("P006", 25.00);

        productCatalog.put("P001", new Product("P001", "Laptop", 1200.00));
        productCatalog.put("P002", new Product("P002", "Keyboard", 75.00));
        productCatalog.put("P003", new Product("P003", "Desk Chair", 250.00));
        productCatalog.put("P004", new Product("P004", "Monitor", 300.00));
        productCatalog.put("P005", new Product("P005", "Dining Table", 500.00));
        productCatalog.put("P006", new Product("P006", "Mouse", 25.00));
    }

    // Add item to cart
    public void addItem(String productId, int quantity) {
        if (!productPrices.containsKey(productId)) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        // Update LinkedHashMap
        itemsInCartLinked.put(productId, itemsInCartLinked.getOrDefault(productId, 0) + quantity);

        // Update TreeMap
        Product product = productCatalog.get(productId);
        if (product != null) {
            itemsInCartTree.put(product, itemsInCartTree.getOrDefault(product, 0) + quantity);
        }

        System.out.println("Added " + quantity + " of " + product.getName() + " to cart.");
    }

    // Remove item from cart
    public void removeItem(String productId) {
        if (!itemsInCartLinked.containsKey(productId)) {
            System.out.println("Product with ID " + productId + " not in cart.");
            return;
        }

        int quantityRemoved = itemsInCartLinked.remove(productId);
        Product product = productCatalog.get(productId);
        if (product != null) {
            itemsInCartTree.remove(product);
        }
        System.out.println("Removed product " + product.getName() + " from cart.");
    }

    // Display items in cart (insertion order)
    public void displayCartLinkedHashMap() {
        System.out.println("\n--- Shopping Cart (Insertion Order) ---");
        if (itemsInCartLinked.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        for (Map.Entry<String, Integer> entry : itemsInCartLinked.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = productCatalog.get(productId);
            if (product != null) {
                double itemTotal = product.getPrice() * quantity;
                System.out.printf("%s (ID: %s) x %d @ $%.2f = $%.2f%n", product.getName(), productId, quantity, product.getPrice(), itemTotal);
                total += itemTotal;
            }
        }
        System.out.printf("Total: $%.2f%n", total);
    }

    // Display items in cart (sorted by price)
    public void displayCartTreeMap() {
        System.out.println("\n--- Shopping Cart (Sorted by Price) ---");
        if (itemsInCartTree.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        for (Map.Entry<Product, Integer> entry : itemsInCartTree.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.getPrice() * quantity;
            System.out.printf("%s (ID: %s) x %d @ $%.2f = $%.2f%n", product.getName(), product.getProductId(), quantity, product.getPrice(), itemTotal);
            total += itemTotal;
        }
        System.out.printf("Total: $%.2f%n", total);
    }

    // Calculate total price of items in cart
    public double calculateTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : itemsInCartLinked.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();
            Double price = productPrices.get(productId);
            if (price != null) {
                total += price * quantity;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("--- Shopping Cart Simulation ---");

        cart.addItem("P001", 1); // Laptop
        cart.addItem("P006", 2); // Mouse
        cart.addItem("P003", 1); // Desk Chair
        cart.addItem("P002", 1); // Keyboard
        cart.addItem("P006", 1); // Another Mouse

        cart.displayCartLinkedHashMap();
        cart.displayCartTreeMap();

        System.out.println("\nTotal price of items in cart: $" + String.format("%.2f", cart.calculateTotalPrice()));

        cart.removeItem("P006"); // Remove all mice
        cart.displayCartLinkedHashMap();
        cart.displayCartTreeMap();

        cart.addItem("P007", 1); // Non-existent product
    }
}