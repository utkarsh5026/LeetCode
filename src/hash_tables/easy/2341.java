package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/
// 2341. Maximum Number of Pairs in Array
class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        int left = 0;
        for (Map.Entry<Integer, Integer> freq : cnt.entrySet()) {
            int occurences = freq.getValue();
            pairs += occurences / 2;
            left += occurences % 2;
        }

        return new int[] { pairs, left };
    }
}