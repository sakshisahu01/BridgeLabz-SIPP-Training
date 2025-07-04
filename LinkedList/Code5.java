class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean available;
    Book next, prev;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head, tail;

    void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos == 0) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.available);
            }
            temp = temp.next;
        }
    }

    void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.available);
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int id, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = available;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.available);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.available);
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class Code5 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addAtEnd("1984", "George Orwell", "Dystopian", 1, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", 2, true);
        library.addAtPosition(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 3, false);
        library.displayForward();
        System.out.println("--- Reverse Order ---");
        library.displayReverse();
        System.out.println("--- Search by Title ---");
        library.searchByTitle("1984");
        System.out.println("--- Update Availability ---");
        library.updateAvailability(1, false);
        library.displayForward();
        System.out.println("--- Total Books ---");
        System.out.println(library.countBooks());
        System.out.println("--- Remove Book ID 2 ---");
        library.removeById(2);
        library.displayForward();
    }
}