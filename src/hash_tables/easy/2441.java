package hash_tables.easy;

import java.util.*;

//https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
// 2441. Largest Positive Integer That Exists With Its Negative
class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> negatives = new HashSet<>();

        for (int num : nums) {
            if (num < 0)
                negatives.add(num);
        }

        int maxPos = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0)
                continue;
            if (negatives.contains(-num))
                maxPos = Math.max(maxPos, num);
        }

        return maxPos;
    }
}