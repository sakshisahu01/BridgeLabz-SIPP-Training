package JavaConstructor;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 4.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value.");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayProtectedMember() {
        System.out.println("Accessing protected member 'name' from subclass: " + name);
    }

    public static void main(String[] args) {
        Student student1 = new Student(101, "Alice", 3.8);
        student1.displayStudentDetails();

        // Accessing public member directly
        System.out.println("Public Roll Number: " + student1.rollNumber);

        // Modifying CGPA using public method
        student1.setCGPA(3.9);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        System.out.println();

        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 3.5);
        pgStudent.displayStudentDetails();
        pgStudent.displayProtectedMember();
    }
}