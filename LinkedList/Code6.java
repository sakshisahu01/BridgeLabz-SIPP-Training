class Process {
    int id;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;
    Process tail = null;

    void addProcess(int id, int burstTime, int priority) {
        Process newNode = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    void removeProcess(int id) {
        if (head == null) return;
        Process temp = head, prev = tail;
        do {
            if (temp.id == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                    if (temp == tail) tail = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;
        Process current = head;
        int time = 0;
        int totalProcesses = 0;
        double totalWaitingTime = 0, totalTurnaroundTime = 0;

        // Count total processes
        Process temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("--- Starting Round Robin Scheduling ---");
        while (head != null) {
            if (current.remainingTime <= timeQuantum) {
                time += current.remainingTime;
                current.remainingTime = 0;
                current.turnaroundTime = time;
                current.waitingTime = current.turnaroundTime - current.burstTime;
                totalWaitingTime += current.waitingTime;
                totalTurnaroundTime += current.turnaroundTime;
                System.out.println("Process " + current.id + " executed completely. Turnaround: " + current.turnaroundTime + ", Waiting: " + current.waitingTime);
                Process next = current.next;
                removeProcess(current.id);
                current = next == current ? null : next;
            } else {
                time += timeQuantum;
                current.remainingTime -= timeQuantum;
                System.out.println("Process " + current.id + " executed for " + timeQuantum + " units. Remaining: " + current.remainingTime);
                current = current.next;
            }
            displayQueue();
        }

        System.out.println("--- Scheduling Complete ---");
        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }

    void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[ID: " + temp.id + ", RT: " + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }
}

class Code6 {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 6, 3);
        scheduler.addProcess(4, 8, 2);

        scheduler.simulateRoundRobin(3);
    }
}
