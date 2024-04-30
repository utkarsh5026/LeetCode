package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// 215. Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k)
            return -1;

        PriorityQueue<Integer> numberSorter = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            numberSorter.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            numberSorter.poll();
        }

        return numberSorter.peek();
    }
}
