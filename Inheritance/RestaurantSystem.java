package Inheritance;

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();  // abstract method
}

// Subclass: Chef
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("\nRole: Chef");
        displayPersonDetails();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Prepares meals and designs menu.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println("\nRole: Waiter");
        displayPersonDetails();
        System.out.println("Tables Assigned: " + tableCount);
        System.out.println("Duties: Takes orders and serves customers.");
    }
}

// Main class to test the system
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Rohit", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Amit", 202, 5);

        chef.performDuties();
        waiter.performDuties();
    }
}
