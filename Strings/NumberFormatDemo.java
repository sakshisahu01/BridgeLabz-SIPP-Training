import java.util.Scanner;

public class NumberFormatDemo {

    static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Converted number: " + num);
    }

    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Converted number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in text: ");
        String input = scanner.next();

        generateException(input);
        handleException(input);
    }
}
