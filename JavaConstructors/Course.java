public class Course {
    // Instance variables
    String courseName;
    int duration; // in months
    double fee;

    // Class variable (common to all courses)
    static String instituteName = "ABC Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Initial course objects
        Course c1 = new Course("Java Programming", 3, 5000.0);
        Course c2 = new Course("Web Development", 4, 7000.0);

        System.out.println("Before updating institute name:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        // Update the shared institute name
        Course.updateInstituteName("TechSkill Academy");

        System.out.println("\nAfter updating institute name:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
