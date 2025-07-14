import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class FileReaderLineByLine {

    private static final String TEST_FILE_NAME = "sample.txt";

    public static void createSampleFile() {
        try (java.io.FileWriter writer = new java.io.FileWriter(TEST_FILE_NAME)) {
            writer.write("This is the first line.\n");
            writer.write("This is the second line.\n");
            writer.write("And this is the third line.\n");
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void readFileLineByLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nReading file line by line:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createSampleFile(); // Create a sample file for testing
        readFileLineByLine(TEST_FILE_NAME);

        // Clean up the created file
        new File(TEST_FILE_NAME).delete();
    }
}