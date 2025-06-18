import java.util.Scanner;

public class SubstringComparison {

    static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String fromCharAt = customSubstring(text, start, end);
        String fromSubstring = text.substring(start, end);
        boolean isEqual = compareStrings(fromCharAt, fromSubstring);

        System.out.println("Custom substring: " + fromCharAt);
        System.out.println("Built-in substring: " + fromSubstring);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
