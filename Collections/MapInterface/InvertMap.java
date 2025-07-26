package Collections.MapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class InvertMap {

    // Method to invert a map, handling duplicate values by storing them in a Set
    public static <K, V> Map<V, Set<K>> invertMap(Map<K, V> originalMap) {
        Map<V, Set<K>> invertedMap = new HashMap<>();

        if (originalMap == null || originalMap.isEmpty()) {
            return invertedMap;
        }

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // If the value is already a key in the inverted map, add the current key to its set
            // Otherwise, create a new set with the current key
            invertedMap.computeIfAbsent(value, k -> new HashSet<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        System.out.println("Original Map 1: " + map1);
        Map<Integer, Set<String>> invertedMap1 = invertMap(map1);
        System.out.println("Inverted Map 1: " + invertedMap1);

        System.out.println("\n----------------------------------------\n");

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 1);
        map2.put("banana", 2);
        map2.put("cherry", 1); // Duplicate value
        map2.put("date", 3);
        System.out.println("Original Map 2 (with duplicate value): " + map2);
        Map<Integer, Set<String>> invertedMap2 = invertMap(map2);
        System.out.println("Inverted Map 2: " + invertedMap2);

        System.out.println("\n----------------------------------------\n");

        Map<Integer, String> map3 = new HashMap<>();
        map3.put(101, "John");
        map3.put(102, "Jane");
        map3.put(103, "John"); // Duplicate value
        System.out.println("Original Map 3 (with duplicate value): " + map3);
        Map<String, Set<Integer>> invertedMap3 = invertMap(map3);
        System.out.println("Inverted Map 3: " + invertedMap3);

        System.out.println("\n----------------------------------------\n");

        Map<String, String> emptyMap = new HashMap<>();
        System.out.println("Original Empty Map: " + emptyMap);
        Map<String, Set<String>> invertedEmptyMap = invertMap(emptyMap);
        System.out.println("Inverted Empty Map: " + invertedEmptyMap);

        System.out.println("\n----------------------------------------\n");

        Map<String, String> nullMap = null;
        System.out.println("Original Null Map: " + nullMap);
        Map<String, Set<String>> invertedNullMap = invertMap(nullMap);
        System.out.println("Inverted Null Map: " + invertedNullMap);
    }
}