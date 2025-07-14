import java.util.Arrays;
import java.util.HashSet;

public class ChallengeSearch {

    // Linear Search for the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                seen.add(num);
            }
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return nums.length + 1; // Should not reach here if problem constraints are met
    }

    // Binary Search for the target index
    public static int binarySearchTargetIndex(int[] nums, int target) {
        Arrays.sort(nums); // Ensure the array is sorted for binary search
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Linear Search for first missing positive
        int[] arr1 = {1, 2, 0};
        System.out.println("First missing positive in {1, 2, 0}: " + findFirstMissingPositive(arr1));

        int[] arr2 = {3, 4, -1, 1};
        System.out.println("First missing positive in {3, 4, -1, 1}: " + findFirstMissingPositive(arr2));

        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println("First missing positive in {7, 8, 9, 11, 12}: " + findFirstMissingPositive(arr3));

        // Test Binary Search for target index
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        int target1 = 7;
        System.out.println("Index of " + target1 + " in sorted array: " + binarySearchTargetIndex(sortedArr, target1));

        int target2 = 4;
        System.out.println("Index of " + target2 + " in sorted array: " + binarySearchTargetIndex(sortedArr, target2));
    }
}