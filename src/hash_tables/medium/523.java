package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/continuous-subarray-sum/description/?
// 523. Continuous Subarray Sum
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currSum = 0;
        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int remainder = currSum % k;

            if (sumMap.containsKey(remainder)) {
                if (i - sumMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                sumMap.put(remainder, i);
            }
        }

        return false;
    }
}
