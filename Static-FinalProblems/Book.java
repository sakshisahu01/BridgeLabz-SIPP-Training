class Book {
    // Static variable shared by all books
    static String libraryName = "City Central Library";

    // Instance variables
    private String title;
    private String author;

    // Final variable for unique identifier
    private final String isbn;

    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display the library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayDetails() {
        // Using instanceof to check type before displaying
        if (this instanceof Book) {
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN  : " + isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }
}

// Main class to test Book class
public class Main {
    public static void main(String[] args) {
        Book.displayLibraryName();
        System.out.println();

        Book book1 = new Book("The Alchemist", "Paulo Coelho", "ISBN12345");
        Book book2 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "ISBN67890");

        book1.displayDetails();
        System.out.println();
        book2.displayDetails();
    }
}
