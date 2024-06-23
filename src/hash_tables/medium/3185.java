package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/
// 3185. Count Pairs That Form a Complete Day II
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> need = new HashMap<>();
        long pairs = 0;

        for (int hour : hours) {
            int modHour = hour % 24;
            int complement = (24 - modHour) % 24;
            pairs += need.getOrDefault(complement, 0);

            need.put(modHour, need.getOrDefault(modHour, 0) + 1);
        }

        return pairs;
    }
}