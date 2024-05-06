package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
// 1679. Max Number of K-Sum Pairs
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> requiredValues = new HashMap<>();
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int need = k - curr;

            if (requiredValues.containsKey(need) && requiredValues.get(need) > 0) {
                requiredValues.put(need, requiredValues.get(need) - 1);
                operations++;
                continue;
            }

            requiredValues.computeIfAbsent(curr, freq -> 0);
            requiredValues.put(curr, requiredValues.get(curr) + 1);
        }

        return operations;
    }
}