package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
// 974. Subarray Sums Divisible by K
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainders = new HashMap<>();
        remainders.put(0, 1);
        int currentSum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = currentSum % k;

            if (remainder < 0)
                remainder += k;

            remainders.computeIfAbsent(remainder, count -> 0);
            cnt += remainders.get(remainder);
            remainders.put(remainder, remainders.get(remainder) + 1);
        }

        return cnt;
    }
}