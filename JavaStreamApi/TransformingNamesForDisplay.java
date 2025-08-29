package JavaStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {

    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
                "alice", "bob", "charlie", "david", "eve"
        );

        // Convert names to uppercase and sort them alphabetically
        List<String> transformedNames = customerNames.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Transformed Names for Display:");
        transformedNames.forEach(System.out::println);
    }
}