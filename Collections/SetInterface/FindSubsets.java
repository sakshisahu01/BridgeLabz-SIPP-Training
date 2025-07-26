package Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class FindSubsets {

    // Method to check if one set is a subset of another
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return false; // Or handle as per specific requirements
        }
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(5);

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " -> Is Set1 a subset of Set2: " + isSubset(set1, set2));
        System.out.println("Set2: " + set2 + ", Set1: " + set1 + " -> Is Set2 a subset of Set1: " + isSubset(set2, set1));
        System.out.println("Set1: " + set1 + ", Set3: " + set3 + " -> Is Set1 a subset of Set3: " + isSubset(set1, set3));

        System.out.println("\n----------------------------------------\n");

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");

        Set<String> setB = new HashSet<>();
        setB.add("apple");
        setB.add("banana");
        setB.add("orange");

        System.out.println("SetA: " + setA + ", SetB: " + setB + " -> Is SetA a subset of SetB: " + isSubset(setA, setB));
    }
}