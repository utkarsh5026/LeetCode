package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/keep-multiplying-found-values-by-two/description/
// 2154. Keep Multiplying Found Values by Two
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> current = new HashSet<>();
        for (int num : nums) {
            current.add(num);
        }

        while (current.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
