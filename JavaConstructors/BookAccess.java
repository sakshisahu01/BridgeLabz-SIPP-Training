package JavaConstructor;

class BookAccess {
    public String ISBN;
    protected String title;
    private String author;

    public BookAccess(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends BookAccess {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayAccessDetails() {
        System.out.println("Accessing public ISBN from subclass: " + ISBN);
        System.out.println("Accessing protected title from subclass: " + title);
        // Cannot access private author directly: System.out.println(author);
    }

    public static void main(String[] args) {
        BookAccess book1 = new BookAccess("978-0321765723", "Effective Java", "Joshua Bloch");
        book1.displayBookDetails();

        // Accessing public member directly
        System.out.println("Public ISBN: " + book1.ISBN);

        // Setting and getting private author using public methods
        book1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + book1.getAuthor());

        System.out.println();

        EBook ebook1 = new EBook("978-1234567890", "Clean Code", "Robert C. Martin");
        ebook1.displayBookDetails();
        ebook1.displayAccessDetails();
    }
}