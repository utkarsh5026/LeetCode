package hash_tables.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
// 217. Contains Duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num))
                return true;
            unique.add(num);
        }

        return false;
    }
}