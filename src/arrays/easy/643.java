package arrays.easy;

/// https://leetcode.com/problems/maximum-average-subarray-i/description/
// 643. Maximum Average Subarray I
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = doInitiatlSum(nums, k);
        double maxAverage = currentSum / k;

        for (int i = k; i < nums.length; i++) {
            int current = nums[i];
            int toRemove = nums[i - k];
            currentSum = currentSum - toRemove + current;
            maxAverage = Math.max(maxAverage, currentSum / k);
        }
        return maxAverage;
    }

    private double doInitiatlSum(int[] nums, int limit) {
        double sum = 0;

        for (int i = 0; i < limit; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
