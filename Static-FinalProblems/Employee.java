class Employee {
    // Static variable shared by all employees
    static String companyName = "TechSoft Solutions";
    static int totalEmployees = 0;

    // Instance variables
    private String name;
    private String designation;

    // Final variable to prevent ID modification
    private final int id;

    // Constructor using 'this' to initialize instance variables
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayDetails() {
        // Using instanceof to ensure correct object type
        if (this instanceof Employee) {
            System.out.println("Company     : " + companyName);
            System.out.println("Employee ID : " + id);
            System.out.println("Name        : " + name);
            System.out.println("Designation : " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }
}

// Main class to test the Employee class
public class Main {
    public static void main(String[] args) {
        Employee.displayTotalEmployees(); // Before creating employees
        System.out.println();

        Employee emp1 = new Employee("Sakshi Sahu", 101, "Software Engineer");
        Employee emp2 = new Employee("Rahul Verma", 102, "Data Analyst");

        emp1.displayDetails();
        System.out.println();
        emp2.displayDetails();

        System.out.println();
        Employee.displayTotalEmployees(); // After creating employees
    }
}
