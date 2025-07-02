public class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("Alice", 101, 90000, 5);
        employees[1] = new Developer("Bob", 102, 80000, "Java");
        employees[2] = new Intern("Charlie", 103, 30000, "Summer Internship");

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String internshipPeriod;

    public Intern(String name, int id, double salary, String internshipPeriod) {
        super(name, id, salary);
        this.internshipPeriod = internshipPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Period: " + internshipPeriod);
    }
}