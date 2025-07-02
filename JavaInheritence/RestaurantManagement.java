interface Worker {
    void performDuties();
}

public class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101);
        Waiter waiter = new Waiter("Anna", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking food.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}