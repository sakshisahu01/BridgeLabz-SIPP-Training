package JavaConstructor;

class EmployeeAccess {
    public String employeeID;
    protected String department;
    private double salary;

    public EmployeeAccess(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated to: $" + this.salary);
        } else {
            System.out.println("Salary must be positive.");
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends EmployeeAccess {
    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayAccessDetails() {
        System.out.println("Accessing public employeeID from subclass: " + employeeID);
        System.out.println("Accessing protected department from subclass: " + department);
        // Cannot access private salary directly: System.out.println(salary);
    }

    public static void main(String[] args) {
        EmployeeAccess emp1 = new EmployeeAccess("EMP001", "Sales", 60000.00);
        emp1.displayEmployeeDetails();

        emp1.setSalary(65000.00);
        System.out.println("Employee 1 current salary: $" + emp1.getSalary());

        System.out.println();

        Manager manager1 = new Manager("MGR001", "Marketing", 90000.00);
        manager1.displayEmployeeDetails();
        manager1.displayAccessDetails();
    }
}