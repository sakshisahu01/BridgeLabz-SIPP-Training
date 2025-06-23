public class EmployeeDetails {
    public static void main(String[] args) {
        // Create an employee object
        Employee emp1 = new Employee("Sakshi Sahu", 101, 55000);

        // Display employee details
        emp1.displayDetails();
    }
}

// Employee class
class Employee {
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: ₹" + salary);
    }
}
