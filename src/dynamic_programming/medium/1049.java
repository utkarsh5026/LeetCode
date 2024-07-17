package dynamic_programming.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/last-stone-weight-ii/description/
// 1049. Last Stone Weight II
class Solution {
    public int lastStoneWeightII(int[] stones) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(0, 0, stones, memo);
    }

    int solve(int idx, int currentSum, int[] stones, Map<String, Integer> memo) {
        if (idx == stones.length) {
            return Math.abs(currentSum);
        }

        String key = idx + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int includeStone = solve(idx + 1, currentSum + stones[idx], stones, memo);

        int excludeStone = solve(idx + 1, currentSum - stones[idx], stones, memo);
        int result = Math.min(includeStone, excludeStone);
        memo.put(key, result);
        return result;
    }
}
