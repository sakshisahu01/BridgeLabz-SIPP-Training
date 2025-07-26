package Collections.MapInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindKeyWithHighestValue {

    // Method to find the key associated with the highest value in a Map<K, Integer>
    public static <K> Optional<K> findKeyWithHighestValue(Map<K, Integer> map) {
        if (map == null || map.isEmpty()) {
            return Optional.empty();
        }

        // Find the maximum value in the map
        Optional<Integer> maxValue = map.values().stream().max(Integer::compare);

        if (maxValue.isPresent()) {
            // Iterate through the map to find the key(s) associated with the maximum value
            // If multiple keys have the same highest value, this will return the first one encountered
            for (Map.Entry<K, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(maxValue.get())) {
                    return Optional.of(entry.getKey());
                }
            }
        }
        return Optional.empty(); // Should not be reached if map is not empty and maxValue is present
    }

    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("sohil", 95);
        studentScores.put("Raj", 88);
        studentScores.put("Tanuj", 95);
        studentScores.put("nikhil", 76);
        studentScores.put("Sparsh", 99);

        System.out.println("Student Scores: " + studentScores);
        Optional<String> topStudent = findKeyWithHighestValue(studentScores);
        topStudent.ifPresent(s -> System.out.println("Student with highest score: " + s));

        System.out.println("\n----------------------------------------\n");

        Map<Character, Integer> charCounts = new HashMap<>();
        charCounts.put('a', 5);
        charCounts.put('b', 2);
        charCounts.put('c', 8);
        charCounts.put('d', 8);

        System.out.println("Character Counts: " + charCounts);
        Optional<Character> topChar = findKeyWithHighestValue(charCounts);
        topChar.ifPresent(c -> System.out.println("Character with highest count: " + c));

        System.out.println("\n----------------------------------------\n");

        Map<String, Integer> emptyMap = new HashMap<>();
        System.out.println("Empty Map: " + emptyMap);
        Optional<String> resultEmpty = findKeyWithHighestValue(emptyMap);
        System.out.println("Key with highest value in empty map: " + resultEmpty.orElse("N/A"));

        System.out.println("\n----------------------------------------\n");

        Map<String, Integer> singleEntryMap = new HashMap<>();
        singleEntryMap.put("Only", 100);
        System.out.println("Single Entry Map: " + singleEntryMap);
        Optional<String> resultSingle = findKeyWithHighestValue(singleEntryMap);
        System.out.println("Key with highest value in single entry map: " + resultSingle.orElse("N/A"));
    }
}