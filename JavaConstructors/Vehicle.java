public class Vehicle {
    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable (same for all vehicles)
    static double registrationFee = 1500.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: ₹" + registrationFee);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create vehicle objects
        Vehicle v1 = new Vehicle("Amit Sharma", "Car");
        Vehicle v2 = new Vehicle("Sneha Verma", "Bike");

        System.out.println("Before updating registration fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(1800.0);

        System.out.println("\nAfter updating registration fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
