package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-increment-to-make-array-unique/description
// 945. Minimum Increment to Make Array Unique
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int nextUnique = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nextUnique) {
                moves += nextUnique - nums[i];
            }
            nextUnique = Math.max(nextUnique, nums[i]) + 1;
        }

        return moves;
    }
}
