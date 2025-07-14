import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderConvertByteToChar {

    private static final String TEST_FILE_NAME = "binary_data.bin";

    public static void createBinaryFile() {
        try (FileOutputStream fos = new FileOutputStream(TEST_FILE_NAME)) {
            String data = "Hello, this is some text with special characters: éàçü";
            fos.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Error creating binary file: " + e.getMessage());
        }
    }

    public static void readBinaryAsCharacters(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            System.out.println("\nReading binary data as characters (UTF-8):");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createBinaryFile(); // Create a sample binary file
        readBinaryAsCharacters(TEST_FILE_NAME);

        // Clean up the created file
        new File(TEST_FILE_NAME).delete();
    }
}