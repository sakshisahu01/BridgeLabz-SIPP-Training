package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    // Method to reverse a queue using a stack
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        // Dequeue all elements from queue and push them to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Pop all elements from stack and enqueue them back to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);

        System.out.println("\n----------------------------------------\n");

        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.offer("apple");
        stringQueue.offer("banana");
        stringQueue.offer("cherry");

        System.out.println("Original String Queue: " + stringQueue);
        reverseQueue(stringQueue);
        System.out.println("Reversed String Queue: " + stringQueue);
    }
}