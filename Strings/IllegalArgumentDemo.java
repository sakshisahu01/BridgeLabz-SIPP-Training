import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateIllegalArgumentException(String str) {
        String sub = str.substring(5, 2);
    }

    public static void handleIllegalArgumentException(String str) {
        try {
            String sub = str.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException: " + e);
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        generateIllegalArgumentException(input);
        handleIllegalArgumentException(input);
    }
}
