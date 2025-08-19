import java.util.*;
import java.util.stream.Collectors;

// Employee class representing an HR employee
class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double salary;
    
    public Employee(String employeeId, String firstName, String lastName, String department, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }
    
    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    // Methods for name manipulation
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getUppercaseFullName() {
        return getFullName().toUpperCase();
    }
    
    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | Dept: %-15s | Salary: $%,.2f", 
                           employeeId, getFullName(), department, salary);
    }
}

// HR management system
class HRSystem {
    private List<Employee> employees;
    
    public HRSystem() {
        employees = new ArrayList<>();
        initializeEmployees();
    }
    
    private void initializeEmployees() {
        employees.add(new Employee("E001", "John", "Smith", "Engineering", 75000));
        employees.add(new Employee("E002", "Alice", "Johnson", "Marketing", 65000));
        employees.add(new Employee("E003", "Bob", "Williams", "Sales", 58000));
        employees.add(new Employee("E004", "Carol", "Davis", "Finance", 72000));
        employees.add(new Employee("E005", "David", "Miller", "Engineering", 80000));
        employees.add(new Employee("E006", "Emma", "Wilson", "HR", 62000));
        employees.add(new Employee("E007", "Frank", "Moore", "IT", 68000));
        employees.add(new Employee("E008", "Grace", "Taylor", "Marketing", 59000));
    }
    
    // Method 1: Using method reference to uppercase names
    public List<String> getUppercaseNames() {
        return employees.stream()
                       .map(Employee::getFullName)
                       .map(String::toUpperCase)
                       .collect(Collectors.toList());
    }
    
    // Method 2: Using method reference directly on Employee method
    public List<String> getUppercaseEmployeeNames() {
        return employees.stream()
                       .map(Employee::getUppercaseFullName)
                       .collect(Collectors.toList());
    }
    
    // Method 3: Uppercase names by department
    public List<String> getUppercaseNamesByDepartment(String department) {
        return employees.stream()
                       .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                       .map(Employee::getFullName)
                       .map(String::toUpperCase)
                       .collect(Collectors.toList());
    }
    
    // Method 4: Create HR letter template with uppercase names
    public void generateWelcomeLetter() {
        System.out.println("=== HR Welcome Letter Template ===");
        System.out.println("-".repeat(50));
        
        employees.stream()
                .map(Employee::getUppercaseFullName)
                .forEach(name -> {
                    System.out.println("\nDear " + name + ",");
                    System.out.println("Welcome to our company! We are excited to have you join our team.");
                    System.out.println("Sincerely,\nHR Department");
                    System.out.println("-".repeat(30));
                });
    }
    
    // Method 5: Uppercase with additional formatting
    public List<String> getFormattedUppercaseNames() {
        return employees.stream()
                       .map(emp -> String.format("EMPLOYEE: %s (%s)", 
                               emp.getUppercaseFullName(), emp.getEmployeeId()))
                       .collect(Collectors.toList());
    }
    
    // Method 6: Group uppercase names by department
    public Map<String, List<String>> getUppercaseNamesByDepartment() {
        return employees.stream()
                       .collect(Collectors.groupingBy(
                               Employee::getDepartment,
                               Collectors.mapping(
                                       emp -> emp.getFullName().toUpperCase(),
                                       Collectors.toList()
                               )
                       ));
    }
    
    // Method 7: Create name badges
    public void generateNameBadges() {
        System.out.println("=== Employee Name Badges ===");
        employees.stream()
                .map(emp -> String.format("┌─────────────────────┐\n" +
                                        "│ %-19s │\n" +
                                        "│ %-19s │\n" +
                                        "│ ID: %-15s │\n" +
                                        "└─────────────────────┘",
                                        emp.getUppercaseFullName(),
                                        emp.getDepartment().toUpperCase(),
                                        emp.getEmployeeId()))
                .forEach(System.out::println);
    }
    
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}

public class NameUppercasing {
    public static void main(String[] args) {
        HRSystem hr = new HRSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Employee Name Uppercasing System ===\n");
        
        // Demonstrate different ways to uppercase names
        
        // 1. Basic uppercase using method reference
        System.out.println("--- Uppercase Names (Method Reference) ---");
        List<String> uppercaseNames = hr.getUppercaseNames();
        uppercaseNames.forEach(System.out::println);
        
        // 2. Uppercase with employee ID
        System.out.println("\n--- Formatted Uppercase Names ---");
        hr.getFormattedUppercaseNames().forEach(System.out::println);
        
        // 3. Uppercase by department
        System.out.println("\n--- Uppercase Names by Department ---");
        Map<String, List<String>> deptNames = hr.getUppercaseNamesByDepartment();
        deptNames.forEach((dept, names) -> {
            System.out.println(dept + ": " + names);
        });
        
        // 4. HR welcome letter
        hr.generateWelcomeLetter();
        
        // 5. Name badges
        hr.generateNameBadges();
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Show all uppercase names");
            System.out.println("2. Show uppercase names by department");
            System.out.println("3. Generate welcome letter");
            System.out.println("4. Generate name badges");
            System.out.println("5. Show formatted names");
            System.out.println("6. Quit");
            
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.println("All Uppercase Names:");
                    hr.getUppercaseNames().forEach(System.out::println);
                    break;
                    
                case "2":
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    List<String> deptNamesList = hr.getUppercaseNamesByDepartment(dept);
                    if (deptNamesList.isEmpty()) {
                        System.out.println("No employees in department: " + dept);
                    } else {
                        System.out.println("Uppercase names in " + dept + ":");
                        deptNamesList.forEach(System.out::println);
                    }
                    break;
                    
                case "3":
                    hr.generateWelcomeLetter();
                    break;
                    
                case "4":
                    hr.generateNameBadges();
                    break;
                    
                case "5":
                    System.out.println("Formatted Uppercase Names:");
                    hr.getFormattedUppercaseNames().forEach(System.out::println);
                    break;
                    
                case "6":
                    scanner.close();
                    System.out.println("HR system shutting down...");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}