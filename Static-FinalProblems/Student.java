class Student {
    // Static variable shared across all students
    static String universityName = "Global Tech University";
    static int totalStudents = 0;

    // Final variable: rollNumber is unique and immutable
    private final int rollNumber;

    // Instance variables
    private String name;
    private char grade;

    // Constructor using 'this' to initialize variables
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total number of enrolled students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to update grade after validating instance
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully for Roll No: " + rollNumber);
        } else {
            System.out.println("Invalid student object. Grade update failed.");
        }
    }

    // Method to display student details
    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University   : " + universityName);
            System.out.println("Name         : " + name);
            System.out.println("Roll Number  : " + rollNumber);
            System.out.println("Grade        : " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }
}

// Main class containing the main() method
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Display total students before enrollment
        Student.displayTotalStudents();
        System.out.println();

        // Creating student objects
        Student s1 = new Student("Ayesha Khan", 101, 'A');
        Student s2 = new Student("Rohan Gupta", 102, 'B');

        // Display student details
        System.out.println("=== Student 1 ===");
        s1.displayDetails();
        System.out.println();

        System.out.println("=== Student 2 ===");
        s2.displayDetails();
        System.out.println();

        // Show total enrolled students
        Student.displayTotalStudents();
        System.out.println();

        // Update grade for a student
        System.out.println("Updating grade for Rohan...\n");
        s2.updateGrade('A');

        // Display updated student details
        System.out.println();
        System.out.println("=== Updated Student 2 ===");
        s2.displayDetails();
    }
}
