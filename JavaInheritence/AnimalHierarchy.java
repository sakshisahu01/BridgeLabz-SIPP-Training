public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 3);
        animals[1] = new Cat("Whiskers", 2);
        animals[2] = new Bird("Tweety", 1);

        for (Animal animal : animals) {
            System.out.println(animal.name + " says:");
            animal.makeSound();
        }
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}