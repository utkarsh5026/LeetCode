package hash_tables.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-subarrays-with-equal-sum/description/
// 2395. Find Subarrays With Equal Sums
class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sumEncountered = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];
            int sum = curr + next;
            if (sumEncountered.contains(sum))
                return true;
            sumEncountered.add(sum);
        }

        return false;
    }
}