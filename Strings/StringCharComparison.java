import java.util.Scanner;

public class StringCharComparison {

    static char[] getChars(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }
        return result;
    }

    static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] userMethod = getChars(input);
        char[] builtInMethod = input.toCharArray();

        boolean isEqual = compareArrays(userMethod, builtInMethod);

        System.out.println("User-defined method output:");
        for (char c : userMethod) System.out.print(c + " ");
        System.out.println("\nBuilt-in method output:");
        for (char c : builtInMethod) System.out.print(c + " ");
        System.out.println("\nAre both arrays equal? " + isEqual);
    }
}
