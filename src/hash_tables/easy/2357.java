package hash_tables.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
// 2357. Make Array Zero by Subtracting Equal Amounts
class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == 0)
                continue;
            numSet.add(curr);
        }

        return numSet.size();
    }
}