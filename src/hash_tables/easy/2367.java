package hash_tables.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-arithmetic-triplets/description/
// 2367. Number of Arithmetic Triplets
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> numSet = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (numSet.contains(num - diff) && numSet.contains(num - 2 * diff)) {
                count++;
            }
            numSet.add(num);
        }

        return count;
    }
}
