package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/
// 2442. Count Number of Distinct Integers After Reverse Operations
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
            StringBuilder reversed = new StringBuilder();
            reversed.append(num);
            unique.add(Integer.parseInt(reversed.reverse().toString()));
        }

        return unique.size();
    }
}