package greedy.easy;

import java.util.Arrays;

// https://leetcode.com/problems/array-partition/description/
// 561. Array Partition
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
