import java.util.*;

public class CustomSplitCompare {

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

    public static String[] manualSplit(String str) {
        int length = getLength(str);
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') spaceCount++;
        }

        int[] spaceIndexes = new int[spaceCount + 2];
        int index = 1;
        spaceIndexes[0] = -1;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length;

        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void displayArray(String[] arr, String title) {
        System.out.println(title);
        for (String word : arr) {
            System.out.println("[" + word + "]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] builtInSplit = input.split(" ");
        String[] manualSplitResult = manualSplit(input);

        displayArray(builtInSplit, "Built-in split() result:");
        displayArray(manualSplitResult, "Manual split result:");

        boolean match = compareArrays(builtInSplit, manualSplitResult);
        System.out.println("Do both arrays match? " + match);
    }
}
