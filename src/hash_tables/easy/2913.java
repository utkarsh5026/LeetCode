package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/
// 2913. Subarrays Distinct Element Sum of Squares I
class Solution {
    public int sumCounts(List<Integer> nums) {
        Map<Integer, Integer> distinct = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> unique = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                unique.add(nums.get(j));
                int distinctElements = unique.size();
                distinct.put(distinctElements, distinct.getOrDefault(distinctElements, 0) + 1);
            }
        }

        return countSum(distinct);
    }

    int countSum(Map<Integer, Integer> distinct) {
        int result = 0;
        for (Map.Entry<Integer, Integer> cnt : distinct.entrySet()) {
            int num = cnt.getKey();
            int times = cnt.getValue();

            for (int i = 0; i < times; i++) {
                result += Math.pow(num, 2);
            }
        }

        return result;
    }
}