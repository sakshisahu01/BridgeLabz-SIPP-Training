package Collections.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesPreservingOrder {

    // Method to remove duplicate elements from a list while maintaining the original order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (seen.add(element)) { // add returns true if the element was not already in the set
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 1, 2, 2, 3, 4, 1, 5);
        System.out.println("Original List: " + list1);
        List<Integer> result1 = removeDuplicates(list1);
        System.out.println("List after removing duplicates: " + result1);

        System.out.println("\n----------------------------------------\n");

        List<String> list2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        System.out.println("Original List: " + list2);
        List<String> result2 = removeDuplicates(list2);
        System.out.println("List after removing duplicates: " + result2);
    }
}