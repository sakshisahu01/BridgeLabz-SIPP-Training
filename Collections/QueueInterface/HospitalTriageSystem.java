package Collections.QueueInterface;

import java.util.PriorityQueue;
import java.util.Comparator;

// Represents a patient with a name and a priority level
class Patient {
    private String name;
    private int priority; // Lower number indicates higher priority (e.g., 1 for critical, 5 for minor)

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', priority=" + priority + "}";
    }
}

public class HospitalTriageSystem {

    private PriorityQueue<Patient> triageQueue;

    public HospitalTriageSystem() {
        // Initialize PriorityQueue with a custom comparator to order patients by priority
        // Lower priority number means higher urgency
        triageQueue = new PriorityQueue<>(Comparator.comparingInt(Patient::getPriority));
    }

    // Add a patient to the triage queue
    public void addPatient(String name, int priority) {
        Patient patient = new Patient(name, priority);
        triageQueue.offer(patient);
        System.out.println("Added patient to triage: " + patient);
    }

    // Treat the next patient (patient with the highest priority)
    public void treatNextPatient() {
        if (triageQueue.isEmpty()) {
            System.out.println("No patients in the triage queue.");
            return;
        }
        Patient nextPatient = triageQueue.poll(); // Retrieves and removes the head of this queue
        System.out.println("Treating patient: " + nextPatient.getName() + " (Priority: " + nextPatient.getPriority() + ")");
    }

    // Get the number of patients currently in the queue
    public int getQueueSize() {
        return triageQueue.size();
    }

    // Check if the queue is empty
    public boolean isQueueEmpty() {
        return triageQueue.isEmpty();
    }

    public static void main(String[] args) {
        HospitalTriageSystem triageSystem = new HospitalTriageSystem();

        System.out.println("--- Hospital Triage System Simulation ---");

        triageSystem.addPatient("Sohil", 3); // Minor injury
        triageSystem.addPatient("Tanuj", 1); // Critical condition
        triageSystem.addPatient("Raj", 2); // Serious condition
        triageSystem.addPatient("nikhil", 3); // Minor injury
        triageSystem.addPatient("Sparsh", 1); // Another critical condition

        System.out.println("\nPatients in queue: " + triageSystem.getQueueSize());

        triageSystem.treatNextPatient(); // Should be Bob White (Priority 1)
        triageSystem.treatNextPatient(); // Should be Jane Smith (Priority 1)
        triageSystem.treatNextPatient(); // Should be Peter Jones (Priority 2)

        System.out.println("\nPatients in queue: " + triageSystem.getQueueSize());

        triageSystem.addPatient("Sohil", 4); // Less urgent
        triageSystem.addPatient("Tanuj", 2); // Serious condition

        triageSystem.treatNextPatient(); // Should be Diana Prince (Priority 2)
        triageSystem.treatNextPatient(); // Should be John Doe (Priority 3)
        triageSystem.treatNextPatient(); // Should be Alice Brown (Priority 3)
        triageSystem.treatNextPatient(); // Should be Charlie Green (Priority 4)

        triageSystem.treatNextPatient(); // No patients left

        System.out.println("\nIs queue empty? " + triageSystem.isQueueEmpty());
    }
}