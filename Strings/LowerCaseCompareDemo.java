import java.util.Scanner;

public class LowerCaseCompareDemo {

    public static String convertToLowerUsingCharAt(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String customLower = convertToLowerUsingCharAt(input);
        String builtInLower = input.toLowerCase();

        boolean isSame = compareUsingCharAt(customLower, builtInLower);

        System.out.println("Converted using charAt(): " + customLower);
        System.out.println("Converted using toLowerCase(): " + builtInLower);
        System.out.println("Are both results same? " + isSame);
    }
}
