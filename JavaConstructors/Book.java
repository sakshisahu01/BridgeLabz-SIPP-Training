public class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Using default constructor
        Book book1 = new Book();
        System.out.println("Book 1 Details:");
        book1.displayDetails();

        // Using parameterized constructor
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 299.99);
        System.out.println("\nBook 2 Details:");
        book2.displayDetails();
    }
}
