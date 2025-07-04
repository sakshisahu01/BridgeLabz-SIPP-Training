class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head;

    void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos == 0) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    Student searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateGrade(int roll, String newGrade) {
        Student temp = searchByRoll(roll);
        if (temp != null) {
            temp.grade = newGrade;
        }
    }

    void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        StudentList list = new StudentList();

        list.addAtBeginning(1, "Amit", 20, "A");
        list.addAtEnd(2, "Sita", 21, "B");
        list.addAtPosition(1, 3, "Rahul", 22, "C");
        list.displayAll();

        System.out.println("After Deletion:");
        list.deleteByRoll(2);
        list.displayAll();

        System.out.println("After Grade Update:");
        list.updateGrade(3, "A+");
        list.displayAll();
    }
}
