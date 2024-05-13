package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
// 560. Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCntMap = new HashMap<>();
        sumCntMap.put(0, 1);
        int currentSum = 0;
        int equalSums = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int diff = currentSum - k;
            if (sumCntMap.containsKey(diff))
                equalSums += sumCntMap.get(diff);

            sumCntMap.computeIfAbsent(currentSum, count -> 0);
            sumCntMap.put(currentSum, sumCntMap.get(currentSum) + 1);
        }
        return equalSums;
    }
}