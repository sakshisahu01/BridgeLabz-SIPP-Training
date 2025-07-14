public class BinarySearchPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak element index: " + findPeakElement(nums1));

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element index: " + findPeakElement(nums2));

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Peak element index: " + findPeakElement(nums3));

        int[] nums4 = {5, 4, 3, 2, 1};
        System.out.println("Peak element index: " + findPeakElement(nums4));
    }
}