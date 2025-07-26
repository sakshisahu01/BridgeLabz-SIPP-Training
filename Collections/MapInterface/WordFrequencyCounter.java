package Collections.MapInterface;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    // Method to count the frequency of each word in a given text
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Handle null or empty text
        if (text == null || text.trim().isEmpty()) {
            return wordFrequencies;
        }

        // Convert text to lowercase and split into words using regex that handles spaces and punctuation
        String[] words = text.toLowerCase().split("\\W+"); // Splits by any non-word character

        for (String word : words) {
            if (!word.isEmpty()) { // Ensure no empty strings from split (e.g., from multiple spaces)
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequencies;
    }

    public static void main(String[] args) {
        String text1 = "Hello world, this is a test. Hello again, world!";
        Map<String, Integer> frequencies1 = countWordFrequency(text1);
        System.out.println("Word frequencies for text 1: " + frequencies1);

        System.out.println("\n----------------------------------------\n");

        String text2 = "Java is a programming language. Java is widely used.";
        Map<String, Integer> frequencies2 = countWordFrequency(text2);
        System.out.println("Word frequencies for text 2: " + frequencies2);

        System.out.println("\n----------------------------------------\n");

        String text3 = "A B A C B A";
        Map<String, Integer> frequencies3 = countWordFrequency(text3);
        System.out.println("Word frequencies for text 3: " + frequencies3);

        System.out.println("\n----------------------------------------\n");

        String text4 = "";
        Map<String, Integer> frequencies4 = countWordFrequency(text4);
        System.out.println("Word frequencies for empty text: " + frequencies4);

        System.out.println("\n----------------------------------------\n");

        String text5 = null;
        Map<String, Integer> frequencies5 = countWordFrequency(text5);
        System.out.println("Word frequencies for null text: " + frequencies5);
    }
}