import java.util.*;

public class StringLengthFinder {

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.next();

        int customLength = getLength(input);
        int builtInLength = input.length();

        System.out.println("Length using manual method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);
    }
}
