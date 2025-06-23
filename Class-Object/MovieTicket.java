

 class MovieTicket {
    // Private attributes
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor to initialize movie name (seat and price set on booking)
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false; // Ticket is not booked initially
    }

    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("This ticket is already booked.");
        }
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Name : " + movieName);
        if (isBooked) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price      : ₹" + price);
        } else {
            System.out.println("Ticket not booked yet.");
        }
    }

    // Main method to test the MovieTicket class
    public static void main(String[] args) {
        // Create a MovieTicket object
        MovieTicket ticket1 = new MovieTicket("Avengers: Endgame");

        // Display before booking
        ticket1.displayTicketDetails();
        System.out.println();

        // Book the ticket
        ticket1.bookTicket("A12", 250.0);
        System.out.println();

        // Display after booking
        ticket1.displayTicketDetails();

        // Try to book again (should fail)
        System.out.println();
        ticket1.bookTicket("B15", 300.0);
    }
}
