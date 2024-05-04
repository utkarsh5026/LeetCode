package arrays.medium;

import java.util.Arrays;

// https://leetcode.com/problems/increasing-triplet-subsequence/description/
// 334. Increasing Triplet Subsequence
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] smallestTwo = new int[2];
        Arrays.fill(smallestTwo, Integer.MAX_VALUE);
        smallestTwo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            if (currentNum < smallestTwo[0])
                smallestTwo[0] = currentNum;
            else if (currentNum > smallestTwo[0] && currentNum < smallestTwo[1])
                smallestTwo[1] = currentNum;
            else if (currentNum > smallestTwo[1])
                return true;
        }

        return false;
    }
}
