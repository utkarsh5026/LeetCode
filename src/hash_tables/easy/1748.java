package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/sum-of-unique-elements/description/
// 1748. Sum of Unique Elements
class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sum elements that appear exactly once
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }
}
