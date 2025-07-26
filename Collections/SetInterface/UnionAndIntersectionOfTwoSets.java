package Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoSets {

    // Method to compute the union of two sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Method to compute the intersection of two sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
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

        Set<Integer> unionSet = union(set1, set2);
        System.out.println("Union: " + unionSet);

        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);

        System.out.println("\n----------------------------------------\n");

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");
        setA.add("orange");

        Set<String> setB = new HashSet<>();
        setB.add("banana");
        setB.add("grape");
        setB.add("kiwi");

        System.out.println("SetA: " + setA);
        System.out.println("SetB: " + setB);

        Set<String> unionSet2 = union(setA, setB);
        System.out.println("Union: " + unionSet2);

        Set<String> intersectionSet2 = intersection(setA, setB);
        System.out.println("Intersection: " + intersectionSet2);
    }
}