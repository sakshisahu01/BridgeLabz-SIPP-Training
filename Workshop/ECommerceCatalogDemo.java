package Workshop;

import java.util.*;

//Product class with attributes
class Product {
 String name;
 String category;
 double price;
 int stock;

 public Product(String name, String category, double price, int stock) {
     this.name = name;
     this.category = category;
     this.price = price;
     this.stock = stock;
 }

 public String toString() {
     return "Name: " + name + ", Category: " + category + ", Price: ₹" + price + ", Stock: " + stock;
 }
}

//Custom exception if product is not found
class ProductNotFoundException extends Exception {
 public ProductNotFoundException(String message) {
     super(message);
 }
}

//Custom exception if stock update is invalid
class StockUpdateException extends Exception {
 public StockUpdateException(String message) {
     super(message);
 }
}

//ProductCatalog class to manage the catalog
class ProductCatalog {
 private List<Product> products = new ArrayList<>();
 private final int MAX_STOCK = 1000;

 // Add a product
 public void addProduct(String name, String category, double price, int stock) {
     products.add(new Product(name, category, price, stock));
 }

 // Search products by name or category
 public List<Product> search(String keyword) {
     List<Product> result = new ArrayList<>();
     for (Product p : products) {
         if (p.name.equalsIgnoreCase(keyword) || p.category.equalsIgnoreCase(keyword)) {
             result.add(p);
         }
     }
     return result;
 }

 // Update stock of a product
 public void updateStock(String productName, int newStock) throws ProductNotFoundException, StockUpdateException {
     Product product = findProductByName(productName);
     if (newStock < 0 || newStock > MAX_STOCK) {
         throw new StockUpdateException("Stock must be between 0 and " + MAX_STOCK);
     }
     product.stock = newStock;
 }

 // Helper method to find product by name
 private Product findProductByName(String name) throws ProductNotFoundException {
     for (Product p : products) {
         if (p.name.equalsIgnoreCase(name)) {
             return p;
         }
     }
     throw new ProductNotFoundException("Product '" + name + "' not found.");
 }

 // Generate product report sorted by price
 public void generateReport(boolean ascending) {
     Comparator<Product> comparator = Comparator.comparingDouble(p -> p.price);
     if (!ascending) {
         comparator = comparator.reversed();
     }

     System.out.println("------------------------------------------------------");
     products.stream()
             .sorted(comparator)
             .forEach(System.out::println);
     System.out.println("------------------------------------------------------");
 }
}

//Main class
public class ECommerceCatalogDemo {
 public static void main(String[] args) {
     ProductCatalog catalog = new ProductCatalog();

     // Add products
     catalog.addProduct("Laptop", "Electronics", 55000, 50);
     catalog.addProduct("Headphones", "Electronics", 1500, 200);
     catalog.addProduct("T-shirt", "Clothing", 700, 100);
     catalog.addProduct("Shoes", "Footwear", 2500, 80);

     // Search
     System.out.println("🔍 Search Results for 'Electronics':");
     List<Product> searchResults = catalog.search("Electronics");
     for (Product p : searchResults) {
         System.out.println(p);
     }

     // Update stock
     try {
         System.out.println("\n⬆️ Updating Stock for 'Laptop' to 75");
         catalog.updateStock("Laptop", 75);
         
         System.out.println("⬆️ Updating Stock for 'Camera' to 20");
         catalog.updateStock("Camera", 20); // Should throw ProductNotFoundException
     } catch (ProductNotFoundException | StockUpdateException e) {
         System.out.println("⚠️ Error: " + e.getMessage());
     }

     // Negative stock case
     try {
         System.out.println("\n⬆️ Updating Stock for 'Shoes' to -10");
         catalog.updateStock("Shoes", -10); // Should throw StockUpdateException
     } catch (Exception e) {
         System.out.println("⚠️ Error: " + e.getMessage());
     }

     // Product report
     System.out.println("\n📄 Product Report (Sorted by Price ASC):");
     catalog.generateReport(true);

     System.out.println("\n📄 Product Report (Sorted by Price DESC):");
     catalog.generateReport(false);
 }
}
