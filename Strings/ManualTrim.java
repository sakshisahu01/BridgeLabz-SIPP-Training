import java.util.*;

public class ManualTrim {

    public static int[] trimIndexes(String input) {
        int start = 0, end = input.length() - 1;
        while (start < input.length() && input.charAt(start) == ' ') start++;
        while (end >= 0 && input.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String getSubstring(String input, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += input.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        int[] indexes = trimIndexes(input);
        String trimmedManual = (indexes[0] <= indexes[1]) ? getSubstring(input, indexes[0], indexes[1]) : "";
        String trimmedBuiltIn = input.trim();
        boolean isEqual = compareStrings(trimmedMan
