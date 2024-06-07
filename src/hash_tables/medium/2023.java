package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/
// 2023. Number of Pairs of Strings With Concatenation Equal to Target
class Solution {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;

        Map<String, Integer> canFormPair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String curr = nums[i];

            if (canFormPair.containsKey(curr)) {
                int pairs = canFormPair.get(curr);
                cnt += pairs;
                continue;
            }

            int toalPairsFormed = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;

                String second = nums[j];
                if ((curr + second).equals(target))
                    toalPairsFormed++;
            }

            cnt += toalPairsFormed;
            canFormPair.put(curr, toalPairsFormed);
        }

        return cnt;
    }
}