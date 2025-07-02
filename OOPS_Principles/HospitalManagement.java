import java.util.*;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String diagnosis, String history);
    void viewRecords();
}

// Abstract class for Patient
abstract class Patient implements MedicalRecord {
    protected String patientId;
    protected String name;
    protected int age;

    // Encapsulated sensitive fields
    private String diagnosis;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method
    public abstract double calculateBill();

    // Interface implementation
    public void addRecord(String diagnosis, String history) {
        this.diagnosis = diagnosis;
        this.medicalHistory = history;
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical History: " + medicalHistory);
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRoomRate;
    private double treatmentCharges;

    public InPatient(String patientId, String name, int age,
                     int daysAdmitted, double dailyRoomRate, double treatmentCharges) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRoomRate = dailyRoomRate;
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyRoomRate) + treatmentCharges;
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private double consultationFee;
    private double diagnosticCharges;

    public OutPatient(String patientId, String name, int age,
                      double consultationFee, double diagnosticCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosticCharges = diagnosticCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + diagnosticCharges;
    }
}

// Main class to test
public class HospitalManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        // Create InPatient and OutPatient objects
        InPatient p1 = new InPatient("IP001", "Amit Sharma", 45, 5, 2000.0, 5000.0);
        p1.addRecord("Pneumonia", "History of asthma");
        patients.add(p1);

        OutPatient p2 = new OutPatient("OP001", "Rita Das", 30, 800.0, 1200.0);
        p2.addRecord("Fever", "Normal health history");
        patients.add(p2);

        // Display details dynamically using polymorphism
        System.out.println("=== Patient Billing Report ===");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            patient.viewRecords();
            System.out.printf("Total Bill: ₹%.2f\n", patient.calculateBill());
            System.out.println("----------------------------------");
        }
    }
}
