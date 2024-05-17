package sliding_window.hard;

import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/description/
// 239. Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> maximumIndices = new ArrayDeque<>();
        List<Integer> maximums = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!maximumIndices.isEmpty() && nums[maximumIndices.peekLast()] <= nums[i]) {
                maximumIndices.pollLast();
            }
            maximumIndices.addLast(i);
        }
        maximums.add(nums[maximumIndices.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!maximumIndices.isEmpty() && maximumIndices.peekFirst() <= i - k) {
                maximumIndices.pollFirst();
            }

            // Maintain the decreasing order in the deque
            while (!maximumIndices.isEmpty() && nums[maximumIndices.peekLast()] <= nums[i]) {
                maximumIndices.pollLast();
            }

            // Add the current element index to the deque
            maximumIndices.addLast(i);

            // Add the current window's maximum to the result
            maximums.add(nums[maximumIndices.peekFirst()]);
        }

        return toArray(maximums);
    }

    int[] toArray(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        return arr;
    }
}
