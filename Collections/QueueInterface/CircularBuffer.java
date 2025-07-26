package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class CircularBuffer<T> {
    private Queue<T> buffer;
    private int capacity;

    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    // Add an element to the buffer. If buffer is full, remove the oldest element.
    public void put(T element) {
        if (buffer.size() == capacity) {
            buffer.poll(); // Remove the oldest element
        }
        buffer.offer(element); // Add the new element
        System.out.println("Put: " + element + ", Buffer: " + buffer);
    }

    // Get an element from the buffer (removes the oldest element)
    public T get() {
        if (buffer.isEmpty()) {
            System.out.println("Buffer is empty. Cannot get element.");
            return null;
        }
        T element = buffer.poll();
        System.out.println("Got: " + element + ", Buffer: " + buffer);
        return element;
    }

    // Peek at the oldest element without removing it
    public T peek() {
        if (buffer.isEmpty()) {
            return null;
        }
        return buffer.peek();
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    // Check if the buffer is full
    public boolean isFull() {
        return buffer.size() == capacity;
    }

    // Get the current size of the buffer
    public int size() {
        return buffer.size();
    }

    // Clear the buffer
    public void clear() {
        buffer.clear();
        System.out.println("Buffer cleared. Buffer: " + buffer);
    }

    public static void main(String[] args) {
        System.out.println("--- Circular Buffer Simulation (Capacity 3) ---");
        CircularBuffer<Integer> intBuffer = new CircularBuffer<>(3);

        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        System.out.println("Is buffer full? " + intBuffer.isFull()); // Should be true

        intBuffer.put(4); // 1 should be removed
        System.out.println("Peek: " + intBuffer.peek()); // Should be 2

        intBuffer.get(); // Should get 2
        intBuffer.put(5); // Add 5

        System.out.println("Current buffer size: " + intBuffer.size()); // Should be 3

        while (!intBuffer.isEmpty()) {
            intBuffer.get();
        }
        System.out.println("Is buffer empty? " + intBuffer.isEmpty()); // Should be true

        intBuffer.get(); // Try to get from empty buffer

        System.out.println("\n--- Circular Buffer Simulation (Capacity 2, Strings) ---");
        CircularBuffer<String> stringBuffer = new CircularBuffer<>(2);
        stringBuffer.put("A");
        stringBuffer.put("B");
        stringBuffer.put("C"); // A should be removed
        stringBuffer.get(); // Should get B
        stringBuffer.put("D");
        stringBuffer.put("E"); // C should be removed
        stringBuffer.clear();
    }
}