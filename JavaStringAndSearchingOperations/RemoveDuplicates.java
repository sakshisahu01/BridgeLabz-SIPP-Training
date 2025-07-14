import java.util.HashSet;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String originalString1 = "programming";
        System.out.println("Original: " + originalString1 + ", Without Duplicates: " + removeDuplicates(originalString1));

        String originalString2 = "hello world";
        System.out.println("Original: " + originalString2 + ", Without Duplicates: " + removeDuplicates(originalString2));
    }
}