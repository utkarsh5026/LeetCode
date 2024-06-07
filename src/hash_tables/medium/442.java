package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// 442. Find All Duplicates in an Array
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index]; // Mark this index as visited by making it negative
            }
        }

        return duplicates;
    }

}
