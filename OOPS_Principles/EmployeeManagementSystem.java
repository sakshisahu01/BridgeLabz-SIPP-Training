import java.util.*;
interface IDepartment{
    void assignDepartment(String departmentName);
    void getDepartment();
}

class Employee{
    int employee_id;
    String employee_name;
    int base_salary;

    Employee(int employee_id, String employee_name, int base_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.base_salary = base_salary;
    }

    //getter and setter methods
    public int getEmployeeId() {
        return employee_id;
    }
    public String getEmployeeName() {
        return employee_name;
    }
    public int base_salary(){
        return base_salary;
    }
    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }
    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }
    public void setBaseSalary(int base_salary) {
        this.base_salary = base_salary;
    }   
    
    
   
    

    void displayDetails() {
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Employee Name: " + employee_name);
        System.out.println("Base Salary: ₹" + base_salary);
    }   
}
class FullTimeEmployee extends Employee implements IDepartment {
    String departmentName;
    double fixedbonus;

    FullTimeEmployee(int employee_id, String employee_name, int base_salary, double fixedbonus) {
        super(employee_id, employee_name, base_salary);
        this.fixedbonus = fixedbonus;
    }

    public double calculateSalary() {
        return base_salary + fixedbonus;
    }   
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void getDepartment() {
        System.out.println("Department: " + departmentName);
    }
    
}
class PartTimeEmployee extends Employee implements IDepartment {
    String departmentName;
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(int employee_id, String employee_name, int base_salary, double hourlyRate, int hoursWorked) {
        super(employee_id, employee_name, base_salary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return base_salary + (hourlyRate * hoursWorked);
    }   
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void getDepartment() {
        System.out.println("Department: " + departmentName);
    }
    
}







public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(101, "Alice", 50000, 10000);
        fullTimeEmployee.assignDepartment("HR");
        
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(102, "Bob", 30000, 200, 20);
        partTimeEmployee.assignDepartment("IT");

        employees.add(fullTimeEmployee);
        employees.add(partTimeEmployee);


        for (Employee employee : employees) {
            employee.displayDetails();
            if (employee instanceof FullTimeEmployee) {
                System.out.println("Total Salary: ₹" + ((FullTimeEmployee) employee).calculateSalary());
            } else if (employee instanceof PartTimeEmployee) {
                System.out.println("Total Salary: ₹" + ((PartTimeEmployee) employee).calculateSalary());
            }
            if (employee instanceof IDepartment) {
                ((IDepartment) employee).getDepartment();
            }
            System.out.println();
        }   
    }
    


	
}
