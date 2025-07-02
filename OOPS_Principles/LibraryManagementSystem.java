interface IReservable{
    void reserveitem();
    void getcheckAvailability();
}

class LibraryItem{
    int itemId;
    String itenname;
    String author;

    LibraryItem(int itemId, String itenname, String author) {
        this.itemId = itemId;
        this.itenname = itenname;
        this.author = author;
    }
    //getter and settter methods
    public int getitemId(){
        return itemId;
    }
    public String getitenname(){
        return itenname;
    }
    public String getauthor(){
        return author;
    }
    public void setitemId(int itemId) {
        this.itemId = itemId;
    }
    public void setitenname(String itenname) {
        this.itenname = itenname;
    }
    public void setauthor(String author) {
        this.author = author;
    }
    void displayDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itenname);
        System.out.println("Author: " + author);
    }
}
class Book extends LibraryItem implements IReservable {
    String genre;
    boolean isAvailable;

    Book(int itemId, String itenname, String author, String genre) {
        super(itemId, itenname, author);
        this.genre = genre;
        this.isAvailable = true; // Default availability
    }

    @Override
    public void reserveitem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    @Override
    public void getcheckAvailability() {
        if (isAvailable) {
            System.out.println("Book is available for reservation.");
        } else {
            System.out.println("Book is currently reserved.");
        }
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Genre: " + genre);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}
class Magazine extends LibraryItem implements IReservable {
    String issue;
    boolean isAvailable;

    Magazine(int itemId, String itenname, String author, String issue) {
        super(itemId, itenname, author);
        this.issue = issue;
        this.isAvailable = true; // Default availability
    }

    @Override
    public void reserveitem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    @Override
    public void getcheckAvailability() {
        if (isAvailable) {
            System.out.println("Magazine is available for reservation.");
        } else {
            System.out.println("Magazine is currently reserved.");
        }
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Issue: " + issue);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}
class DVD extends LibraryItem implements IReservable {
    String director;
    boolean isAvailable;

    DVD(int itemId, String itenname, String author, String director) {
        super(itemId, itenname, author);
        this.director = director;
        this.isAvailable = true; // Default availability
    }

    @Override
    public void reserveitem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    @Override
    public void getcheckAvailability() {
        if (isAvailable) {
            System.out.println("DVD is available for reservation.");
        } else {
            System.out.println("DVD is currently reserved.");
        }
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Director: " + director);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
        Magazine magazine1 = new Magazine(201, "National Geographic", "Various", "January 2023");
        DVD dvd1 = new DVD(301, "Inception", "Christopher Nolan", "Christopher Nolan");

        book1.displayDetails();
        book1.reserveitem();
        book1.getcheckAvailability();
        
        System.out.println();

        magazine1.displayDetails();
        magazine1.reserveitem();
        magazine1.getcheckAvailability();
        
        System.out.println();

        dvd1.displayDetails();
        dvd1.reserveitem();
        dvd1.getcheckAvailability();
    }
    
}
