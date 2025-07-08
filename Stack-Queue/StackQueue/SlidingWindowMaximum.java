package StackAndQueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // store indices

        for (int i = 0; i < nums.length; i++) {

            // Step 1: Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Step 2: Remove indices whose values are smaller than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current index
            deque.offer(i);

            // Step 4: Add the max value for the current window to result
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Max of each sliding window:");
        System.out.println(result);
    }
}
