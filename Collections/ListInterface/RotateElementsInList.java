package Collections.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateElementsInList {

    // Method to rotate the elements of a list by a given number of positions
    public static <T> void rotateList(List<T> list, int positions) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int actualPositions = positions % size;
        if (actualPositions < 0) {
            actualPositions += size;
        }
        Collections.rotate(list, -actualPositions);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy1 = 2;
        System.out.println("Original List: " + list1 + ", Rotate by: " + rotateBy1);
        rotateList(list1, rotateBy1);
        System.out.println("Rotated List: " + list1);

        System.out.println("\n----------------------------------------\n");

        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        int rotateBy2 = 3;
        System.out.println("Original List: " + list2 + ", Rotate by: " + rotateBy2);
        rotateList(list2, rotateBy2);
        System.out.println("Rotated List: " + list2);

        System.out.println("\n----------------------------------------\n");

        List<Double> list3 = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4));
        int rotateBy3 = -1; // Rotate left by 1
        System.out.println("Original List: " + list3 + ", Rotate by: " + rotateBy3);
        rotateList(list3, rotateBy3);
        System.out.println("Rotated List: " + list3);
    }
}