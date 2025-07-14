import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerformanceComparisonChallenge {

    private static final int STRING_CONCAT_OPERATIONS = 1_000_000;
    private static final String LARGE_FILE_NAME = "large_test_file.txt";
    private static final long LARGE_FILE_SIZE_MB = 10; // Reduced from 100MB for practical execution

    // Helper to create a dummy large file
    public static void createLargeFile(long sizeMB) throws IOException {
        long sizeBytes = sizeMB * 1024 * 1024;
        try (FileOutputStream fos = new FileOutputStream(LARGE_FILE_NAME)) {
            byte[] data = "This is a line for testing file reading performance. ".getBytes(StandardCharsets.UTF_8);
            long bytesWritten = 0;
            while (bytesWritten < sizeBytes) {
                fos.write(data);
                bytesWritten += data.length;
            }
        }
    }

    public static void main(String[] args) {
        // Part 1: StringBuilder vs StringBuffer Concatenation
        System.out.println("\n--- String Concatenation Performance ---");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Create a small list of strings to concatenate
            stringList.add("part" + i);
        }

        // StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STRING_CONCAT_OPERATIONS; i++) {
            for (String s : stringList) {
                sb.append(s);
            }
            sb.setLength(0); // Clear for next iteration
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1_000_000; // milliseconds
        System.out.printf("StringBuilder Concatenation (%d ops): %d ms%n", STRING_CONCAT_OPERATIONS, durationBuilder);

        // StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < STRING_CONCAT_OPERATIONS; i++) {
            for (String s : stringList) {
                sbuf.append(s);
            }
            sbuf.setLength(0); // Clear for next iteration
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1_000_000; // milliseconds
        System.out.printf("StringBuffer Concatenation (%d ops): %d ms%n", STRING_CONCAT_OPERATIONS, durationBuffer);

        // Part 2: FileReader vs InputStreamReader for large file reading
        System.out.println("\n--- File Reading Performance ---");
        try {
            createLargeFile(LARGE_FILE_SIZE_MB);
            System.out.printf("Reading a %,d MB file%n", LARGE_FILE_SIZE_MB);

            // FileReader
            long startTimeFR = System.nanoTime();
            int wordCountFR = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(LARGE_FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    wordCountFR += words.length;
                }
            }
            long endTimeFR = System.nanoTime();
            long durationFR = (endTimeFR - startTimeFR) / 1_000_000; // milliseconds
            System.out.printf("FileReader (Word Count: %,d): %d ms%n", wordCountFR, durationFR);

            // InputStreamReader
            long startTimeISR = System.nanoTime();
            int wordCountISR = 0;
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(LARGE_FILE_NAME), StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(isr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    wordCountISR += words.length;
                }
            }
            long endTimeISR = System.nanoTime();
            long durationISR = (endTimeISR - startTimeISR) / 1_000_000; // milliseconds
            System.out.printf("InputStreamReader (Word Count: %,d): %d ms%n", wordCountISR, durationISR);

            // Clean up the created file
            new File(LARGE_FILE_NAME).delete();

        } catch (IOException e) {
            System.err.println("Error during file operations: " + e.getMessage());
        }

        System.out.println("\nExpected Results:");
        System.out.println("  - StringBuilder should be faster than StringBuffer for concatenation in single-threaded context.");
        System.out.println("  - InputStreamReader (with BufferedReader) is generally more efficient for large file reading than FileReader (with BufferedReader) due to byte-to-character conversion optimization and charset handling.");
    }
}