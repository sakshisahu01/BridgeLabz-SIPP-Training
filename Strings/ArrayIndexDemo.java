import java.util.Scanner;

public class ArrayIndexDemo {

    static void generateException(String[] names) {
        System.out.println("Accessing invalid index:");
        System.out.println(names[names.length]); // causes ArrayIndexOutOfBoundsException
    }

    static void handleException(String[] names) {
        try {
            System.out.println("Accessing invalid index with exception handling:");
            System.out.println(names[names.length]); // causes exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[3];

        System.out.println("Enter 3 names:");
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }

        generateException(names);
        handleException(names);
    }
}
