import java.io.*;
import java.util.*;
import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + "), Salary: " + salary + ", Age: " + age;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT", 60000, 28),
            new Employee(2, "Bob", "HR", 45000, 35),
            new Employee(3, "Charlie", "Finance", 70000, 42),
            new Employee(4, "David", "IT", 55000, 31),
            new Employee(5, "Eva", "HR", 52000, 29),
            new Employee(6, "Frank", "Finance", 48000, 38),
            new Employee(7, "Grace", "IT", 40000, 52),
            new Employee(8, "Helen", "HR", 39000, 41)
        );

        String outputFile = "employee_summary.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // 1. Highest-paid employee in each department
            Map<String, Optional<Employee>> highestPaidByDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                         ));
            bw.write("----- Highest Paid Employee by Department -----\n");
            highestPaidByDept.forEach((dept, emp) -> {
                try {
                    bw.write(dept + " -> " + emp.get() + "\n");
                } catch (IOException e) { e.printStackTrace(); }
            });

            // 2. Average salary department-wise
            Map<String, Double> avgSalaryByDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.averagingDouble(Employee::getSalary)
                         ));
            bw.write("\n----- Average Salary by Department -----\n");
            avgSalaryByDept.forEach((dept, avg) -> {
                try {
                    bw.write(dept + " -> " + avg + "\n");
                } catch (IOException e) { e.printStackTrace(); }
            });

            // 3. Group employees into age brackets
            Map<String, List<Employee>> ageBrackets =
                employees.stream()
                         .collect(Collectors.groupingBy(emp -> {
                             if (emp.getAge() < 30) return "<30";
                             else if (emp.getAge() <= 40) return "30-40";
                             else if (emp.getAge() <= 50) return "40-50";
                             else return ">50";
                         }));
            bw.write("\n----- Employees Grouped by Age Brackets -----\n");
            ageBrackets.forEach((bracket, list) -> {
                try {
                    bw.write(bracket + " -> " + list + "\n");
                } catch (IOException e) { e.printStackTrace(); }
            });

            // 4. Comma-separated names in HR department
            String hrNames =
                employees.stream()
                         .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                         .map(Employee::getName)
                         .collect(Collectors.joining(", "));
            bw.write("\n----- HR Department Employees -----\n");
            bw.write(hrNames + "\n");

            // 5. Partition into High earners and Low earners
            Map<Boolean, List<Employee>> partitioned =
                employees.stream()
                         .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
            bw.write("\n----- High Earners (>50k) -----\n");
            for (Employee e : partitioned.get(true)) {
                bw.write(e + "\n");
            }
            bw.write("\n----- Low Earners (<=50k) -----\n");
            for (Employee e : partitioned.get(false)) {
                bw.write(e + "\n");
            }

            System.out.println("✅ Employee summary written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
