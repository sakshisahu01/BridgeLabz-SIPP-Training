class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head = null;
    Task current = null;

    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 0) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        Task newNode = new Task(id, name, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.id == id && head.next == head) {
            head = null;
            current = null;
            return;
        }
        Task temp = head;
        Task prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    Task tail = head;
                    while (tail.next != head) {
                        tail = tail.next;
                    }
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (current == temp) {
                    current = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTaskAndMoveNext() {
        if (current == null) return;
        System.out.println("ID: " + current.id + ", Name: " + current.name + ", Priority: " + current.priority + ", Due: " + current.dueDate);
        current = current.next;
    }

    void displayAllTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Due: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

class Code3 {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtEnd(1, "Task A", 2, "2025-07-10");
        scheduler.addAtBeginning(2, "Task B", 1, "2025-07-05");
        scheduler.addAtPosition(1, 3, "Task C", 3, "2025-07-15");
        scheduler.displayAllTasks();
        System.out.println("--- View Current & Move Next ---");
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();
        System.out.println("--- Search by Priority 1 ---");
        scheduler.searchByPriority(1);
        System.out.println("--- Remove Task ID 2 ---");
        scheduler.removeById(2);
        scheduler.displayAllTasks();
    }
}
