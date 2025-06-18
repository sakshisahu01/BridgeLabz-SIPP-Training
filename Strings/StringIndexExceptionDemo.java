import java.util.Scanner;

public class StringIndexExceptionDemo {

    public static void generateException(String str) {
        char c = str.charAt(str.length());
    }

    public static void handleException(String str) {
        try {
            char c = str.charAt(str.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        generateException(input);
        handleException(input);
    }
}
