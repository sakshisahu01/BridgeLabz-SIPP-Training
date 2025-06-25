class Patient {
    // Static variable shared by all patients
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    // Final variable for unique patient ID
    private final int patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' to resolve ambiguity
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method to get total patients admitted
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name : " + hospitalName);
            System.out.println("Patient ID    : " + patientID);
            System.out.println("Name          : " + name);
            System.out.println("Age           : " + age);
            System.out.println("Ailment       : " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }
}

// Main class to test Patient class
public class Main {
    public static void main(String[] args) {
        // Display total patients before admission
        Patient.getTotalPatients();
        System.out.println();

        // Create patient objects
        Patient p1 = new Patient(201, "Meena Sharma", 45, "Diabetes");
        Patient p2 = new Patient(202, "Rajiv Nair", 60, "Heart Disease");

        // Display patient details
        System.out.println("=== Patient 1 Details ===");
        p1.displayDetails();
        System.out.println();

        System.out.println("=== Patient 2 Details ===");
        p2.displayDetails();
        System.out.println();

        // Display total patients after admission
        Patient.getTotalPatients();
    }
}
