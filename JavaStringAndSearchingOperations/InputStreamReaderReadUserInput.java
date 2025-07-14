import java.io.*;

public class InputStreamReaderReadUserInput {

    private static final String OUTPUT_FILE_NAME = "user_input.txt";

    public static void main(String[] args) {
        System.out.println("Enter text to write to file (type 'exit' to stop):");

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter writer = new FileWriter(OUTPUT_FILE_NAME)) {

            String line;
            while (true) {
                System.out.print("> ");
                line = br.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
                writer.flush(); // Ensure data is written immediately
            }
            System.out.println("Input saved to " + OUTPUT_FILE_NAME);

        } catch (IOException e) {
            System.err.println("Error during input/output: " + e.getMessage());
        }

        // Optional: Print file content to verify
        System.out.println("\nContent of " + OUTPUT_FILE_NAME + ":");
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_NAME))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException e) {
            System.err.println("Error reading verification file: " + e.getMessage());
        }

        // Clean up the created file
        new File(OUTPUT_FILE_NAME).delete();
    }
}