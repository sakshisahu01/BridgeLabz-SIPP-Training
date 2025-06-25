class Vehicle {
    // Static variable shared by all vehicles
    static double registrationFee = 5000.00; // Default fee

    // Final variable for unique registration number
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this' to resolve ambiguity
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }

    // Method to display vehicle details
    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name         : " + ownerName);
            System.out.println("Vehicle Type       : " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee   : ₹" + registrationFee);
        } else {
            System.out.println("Invalid Vehicle object.");
        }
    }
}

// Main class to test Vehicle class
public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Arjun Singh", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Priya Nair", "Scooter", "DL45ZX5678");

        System.out.println("=== Vehicle 1 Details ===");
        v1.displayRegistrationDetails();
        System.out.println();

        System.out.println("=== Vehicle 2 Details ===");
        v2.displayRegistrationDetails();
        System.out.println();

        // Update the registration fee using static method
        Vehicle.updateRegistrationFee(6000.00);
        System.out.println();

        System.out.println("=== After Updating Fee ===");
        v1.displayRegistrationDetails
