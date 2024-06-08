package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
// 1365. How Many Numbers Are Smaller Than the Current Number
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        Map<Integer, Integer> smallerCountMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // Only store the first occurrence of each number
            if (!smallerCountMap.containsKey(sortedNums[i])) {
                smallerCountMap.put(sortedNums[i], i);
            }
        }

        // Build the result array using the hashmap
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = smallerCountMap.get(nums[i]);
        }

        return result;
    }
}
