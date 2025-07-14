public class LinearSearchFirstNegative {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // No negative number found
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, -5, 30, -15, 40};
        System.out.println("Array: " + java.util.Arrays.toString(arr1) + ", First negative at index: " + findFirstNegative(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Array: " + java.util.Arrays.toString(arr2) + ", First negative at index: " + findFirstNegative(arr2));

        int[] arr3 = {-1, 0, 1, -2};
        System.out.println("Array: " + java.util.Arrays.toString(arr3) + ", First negative at index: " + findFirstNegative(arr3));
    }
}