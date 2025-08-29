package JavaStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {

    static class Doctor {
        String name;
        String specialty;
        List<String> availableDays;

        public Doctor(String name, String specialty, List<String> availableDays) {
            this.name = name;
            this.specialty = specialty;
            this.availableDays = availableDays;
        }

        public String getName() {
            return name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public List<String> getAvailableDays() {
            return availableDays;
        }

        @Override
        public String toString() {
            return "Doctor{name='" + name + "', specialty='" + specialty + "', availableDays=" + availableDays + "}";
        }
    }

    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", Arrays.asList("Monday", "Wednesday", "Saturday")),
                new Doctor("Dr. Jones", "Pediatrics", Arrays.asList("Tuesday", "Friday", "Sunday")),
                new Doctor("Dr. Davis", "Orthopedics", Arrays.asList("Monday", "Tuesday", "Saturday")),
                new Doctor("Dr. Brown", "Cardiology", Arrays.asList("Thursday", "Sunday")),
                new Doctor("Dr. White", "Pediatrics", Arrays.asList("Wednesday", "Saturday"))
        );

        // Find doctors available on weekends and sort by specialty
        List<Doctor> weekendDoctors = doctors.stream()
                .filter(doctor -> doctor.getAvailableDays().contains("Saturday") || doctor.getAvailableDays().contains("Sunday"))
                .sorted((d1, d2) -> d1.getSpecialty().compareTo(d2.getSpecialty()))
                .collect(Collectors.toList());

        System.out.println("Doctors available on weekends (sorted by specialty):");
        weekendDoctors.forEach(System.out::println);
    }
}