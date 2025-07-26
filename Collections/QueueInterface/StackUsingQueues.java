package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation: Add element to the stack
    public void push(T x) {
        // Push x to q2
        q2.offer(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap the names of q1 and q2
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation: Remove element from the stack
    public T pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.poll();
    }

    // Top operation: Get the top element of the stack
    public T top() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        System.out.println("--- Stack Using Queues Simulation ---");

        stack.push(10);
        stack.push(20);
        System.out.println("Pushed 10, 20. Current stack size: " + stack.size());
        System.out.println("Top element: " + stack.top()); // Should be 20

        stack.push(30);
        System.out.println("Pushed 30. Current stack size: " + stack.size());
        System.out.println("Top element: " + stack.top()); // Should be 30

        System.out.println("Popped element: " + stack.pop()); // Should be 30
        System.out.println("Current stack size: " + stack.size());
        System.out.println("Top element: " + stack.top()); // Should be 20

        stack.push(40);
        System.out.println("Pushed 40. Current stack size: " + stack.size());
        System.out.println("Top element: " + stack.top()); // Should be 40

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        System.out.println("Is stack empty? " + stack.isEmpty());

        try {
            stack.pop(); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}