package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    // Method to generate binary numbers from 1 to N using a queue
    public static void generateBinaryNumbers(int n) {
        if (n <= 0) {
            return;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("1"); // Start with the first binary number

        System.out.println("Binary numbers from 1 to " + n + ":");
        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            System.out.println(current);

            // Generate next two binary numbers by appending 0 and 1
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }

    public static void main(String[] args) {
        generateBinaryNumbers(10);
        System.out.println("\n----------------------------------------\n");
        generateBinaryNumbers(5);
    }
}