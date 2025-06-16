
import java.util.*;

class Question6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        for (int n : nums) {
            if (n > 0) {
                if (n % 2 == 0) {
                    System.out.println(n + " is positive and even");
                } else {
                    System.out.println(n + " is positive and odd");
                }
            } else if (n < 0) {
                System.out.println(n + " is negative");
            } else {
                System.out.println(n + " is zero");
            }
        }
        if (nums[0] == nums[4]) {
            System.out.println("First and last are equal");
        } else if (nums[0] > nums[4]) {
            System.out.println("First is greater than last");
        } else {
            System.out.println("First is less than last");
        }
    }
}
