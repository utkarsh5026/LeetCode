package arrays.medium;

import java.util.Arrays;

// https://leetcode.com/problems/increasing-triplet-subsequence/description/
// 334. Increasing Triplet Subsequence
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] triplets = new int[3];
        Arrays.fill(triplets, Integer.MAX_VALUE);
        triplets[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < triplets[0])
                triplets[0] = curr;
            if (curr > triplets[0] && curr < triplets[1])
                triplets[1] = curr;
            else if (curr > triplets[1])
                return true;
        }
        return false;
    }
}
