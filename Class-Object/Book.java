 class Book {
    // Private fields
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Title  : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : ₹" + price);
    }

    // Main method to test
    public static void main(String[] args) {
        Book book1 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", 299.0);
        book1.displayBookDetails();
    }
}
