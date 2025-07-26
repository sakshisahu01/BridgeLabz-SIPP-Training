package Collections.SetInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertSetToSortedList {

    // Method to convert a HashSet of integers into a sorted list in ascending order
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 3, 9, 1, 7));
        System.out.println("Original Set: " + set1);
        List<Integer> sortedList1 = convertSetToSortedList(set1);
        System.out.println("Sorted List: " + sortedList1);

        System.out.println("\n----------------------------------------\n");

        Set<Integer> set2 = new HashSet<>(Arrays.asList(100, 20, 50, 5, 1));
        System.out.println("Original Set: " + set2);
        List<Integer> sortedList2 = convertSetToSortedList(set2);
        System.out.println("Sorted List: " + sortedList2);
    }
}