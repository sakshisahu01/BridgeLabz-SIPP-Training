package Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    // Method to find the symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        union.removeAll(intersection);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        Set<Integer> result = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + result);

        System.out.println("\n----------------------------------------\n");

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");
        setA.add("orange");

        Set<String> setB = new HashSet<>();
        setB.add("banana");
        setB.add("grape");
        setB.add("orange");

        System.out.println("SetA: " + setA);
        System.out.println("SetB: " + setB);
        Set<String> result2 = symmetricDifference(setA, setB);
        System.out.println("Symmetric Difference: " + result2);
    }
}