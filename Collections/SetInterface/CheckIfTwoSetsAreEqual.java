package Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTwoSetsAreEqual {

    // Method to compare two sets and determine if they contain the same elements, regardless of order
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return set1 == set2; // Both null or one null and one not
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(2);

        Set<Integer> set4 = new HashSet<>();
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " -> Equal: " + areSetsEqual(set1, set2));
        System.out.println("Set1: " + set1 + ", Set3: " + set3 + " -> Equal: " + areSetsEqual(set1, set3));
        System.out.println("Set1: " + set1 + ", Set4: " + set4 + " -> Equal: " + areSetsEqual(set1, set4));

        System.out.println("\n----------------------------------------\n");

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");

        Set<String> setB = new HashSet<>();
        setB.add("banana");
        setB.add("apple");

        Set<String> setC = new HashSet<>();
        setC.add("apple");
        setC.add("orange");

        System.out.println("SetA: " + setA + ", SetB: " + setB + " -> Equal: " + areSetsEqual(setA, setB));
        System.out.println("SetA: " + setA + ", SetC: " + setC + " -> Equal: " + areSetsEqual(setA, setC));
    }
}