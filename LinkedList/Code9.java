class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    Ticket head = null, tail = null;

    void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
    }

    void removeTicket(int id) {
        if (head == null) return;
        Ticket temp = head, prev = tail;
        do {
            if (temp.ticketId == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                    if (temp == tail) tail = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String name) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
            }
            temp = temp.next;
        } while (temp != head);
    }

    void searchByMovie(String movie) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Seat: " + temp.seatNumber);
            }
            temp = temp.next;
        } while (temp != head);
    }

    int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

class Code9 {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Inception", "A2", "10:00 AM");
        system.addTicket(3, "Charlie", "Interstellar", "B1", "1:00 PM");

        System.out.println("-- All Tickets --");
        system.displayTickets();

        System.out.println("-- Search by Customer: Alice --");
        system.searchByCustomer("Alice");

        System.out.println("-- Search by Movie: Inception --");
        system.searchByMovie("Inception");

        System.out.println("-- Total Tickets: " + system.countTickets());

        System.out.println("-- Removing Ticket ID 2 --");
        system.removeTicket(2);
        system.displayTickets();
    }
}
