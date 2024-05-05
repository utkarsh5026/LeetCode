package hash_tables.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
// 2461. Maximum Sum of Distinct Subarrays With Length K
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> numsFrequencey = new HashMap<>();
        long[] sums = initialize(numsFrequencey, nums, k);

        long currSum = sums[0];
        long maxSum = sums[1];

        for (int i = k; i < nums.length; i++) {
            int curr = nums[i];
            int outside = nums[i - k];

            decrementFrequency(numsFrequencey, outside);
            incrementFrequency(numsFrequencey, curr);

            currSum = currSum + curr - outside;
            if (allDistinct(numsFrequencey, k))
                maxSum = Math.max(maxSum, currSum);
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    private long[] initialize(Map<Integer, Integer> frequency, int[] nums, int limit) {
        long total = 0;
        for (int i = 0; i < limit; i++) {
            int curr = nums[i];
            total += curr;
            incrementFrequency(frequency, curr);
        }

        if (allDistinct(frequency, limit))
            return new long[] { total, total };

        return new long[] { total, Long.MIN_VALUE };
    }

    private boolean allDistinct(Map<Integer, Integer> frequency, int limit) {
        return frequency.keySet().size() == limit;
    }

    private void incrementFrequency(Map<Integer, Integer> frequency, int num) {
        frequency.computeIfAbsent(num, cnt -> 0);
        int count = frequency.get(num);
        frequency.put(num, count + 1);
    }

    private void decrementFrequency(Map<Integer, Integer> frequency, int num) {
        frequency.put(num, frequency.get(num) - 1);
        if (frequency.get(num) == 0)
            frequency.remove(num);
    }
}
