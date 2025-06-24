package JavaConstructor;

public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    // Parameterized constructor
    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
        System.out.println("LibraryBook constructor called.");
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("\"" + title + "\" has been borrowed.");
        } else {
            System.out.println("\"" + title + "\" is currently not available.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        // Create a library book
        LibraryBook book1 = new LibraryBook("The Lord of the Rings", "J.R.R. Tolkien", 25.50, true);
        book1.displayBookDetails();
        System.out.println("\n");

        // Borrow the book
        book1.borrowBook();
        book1.displayBookDetails();
        System.out.println("\n");

        // Try to borrow again
        book1.borrowBook();
    }
}