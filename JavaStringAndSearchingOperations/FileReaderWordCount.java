import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class FileReaderWordCount {

    private static final String TEST_FILE_NAME = "sample_word_count.txt";

    public static void createSampleFile() {
        try (java.io.FileWriter writer = new java.io.FileWriter(TEST_FILE_NAME)) {
            writer.write("apple banana apple orange banana apple\n");
            writer.write("grape apple kiwi\n");
            writer.write("apple pie is delicious\n");
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+"); // Split by whitespace and convert to lowercase
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        createSampleFile(); // Create a sample file for testing
        String wordToFind = "apple";
        int occurrences = countWordOccurrences(TEST_FILE_NAME, wordToFind);
        System.out.println("The word '" + wordToFind + "' appears " + occurrences + " times in the file.");

        // Clean up the created file
        new File(TEST_FILE_NAME).delete();
    }
}