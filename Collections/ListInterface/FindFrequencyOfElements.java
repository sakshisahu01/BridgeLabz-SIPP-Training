package Collections.ListInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequencyOfElements {

    // Method to count the frequency of each element in a list of strings
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println("Original List: " + inputList);
        Map<String, Integer> result = findFrequency(inputList);
        System.out.println("Frequency Map: " + result);

        System.out.println("\n----------------------------------------\n");

        List<String> anotherList = Arrays.asList("cat", "dog", "cat", "bird", "dog", "cat", "fish");
        System.out.println("Original List: " + anotherList);
        Map<String, Integer> anotherResult = findFrequency(anotherList);
        System.out.println("Frequency Map: " + anotherResult);
    }
}