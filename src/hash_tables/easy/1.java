package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/two-sum/description/
// 1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int need = target - curr;

            if (idxMap.containsKey(need)) {
                indices[0] = idxMap.get(need);
                indices[1] = i;
                break;
            }

            idxMap.put(curr, i);
        }
        return indices;
    }
}