import java.util.Scanner;

public class ExceptionDemo {

    public static void generateStringIndexOutOfBoundsException(String input) {
        char ch = input.charAt(input.length()); 
    }

    public static void handleStringIndexOutOfBoundsException(String input) {
        try {
            char ch = input.charAt(input.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void generateNullPointerException() {
        String text = null;
        int len = text.length();
    }

    public static void handleNullPointerException() {
        try {
            String text = null;
            int len = text.length();
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();

        try {
            generateStringIndexOutOfBoundsException(userInput);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generate method");
        }

        handleStringIndexOutOfBoundsException(userInput);

        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generate method");
        }

        handleNullPointerException();
    }
}
