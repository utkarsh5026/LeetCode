package sliding_window.easy;

import java.util.*;

// https://leetcode.com/problems/longest-harmonious-subsequence/description/
// 594. Longest Harmonious Subsequence
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int longest = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> freq : countMap.entrySet()) {
            int key = freq.getKey();
            int cnt = freq.getValue();
            if (countMap.containsKey(key + 1)) {
                longest = Math.max(longest, cnt + countMap.get(key + 1));
            }
        }

        return longest;
    }
}
