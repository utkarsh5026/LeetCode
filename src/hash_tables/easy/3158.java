package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/
// 3158. Find the XOR of Numbers Which Appear Twice
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int xorResult = 0;
        boolean found = false;

        // Find numbers that appear exactly twice and compute their XOR
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                xorResult ^= entry.getKey();
                found = true;
            }
        }

        // If no number appears twice, return 0
        return found ? xorResult : 0;
    }
}