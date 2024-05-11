package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/degree-of-an-array/description/
// 697. Degree of an Array
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = getCountMap(nums);
        Map<Integer, Integer> first = getFirstOccurrenceMap(nums);
        return calculateShortestSubArray(nums, count, first);
    }

    private Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    private Map<Integer, Integer> getFirstOccurrenceMap(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            first.putIfAbsent(nums[i], i);
        }
        return first;
    }

    private int calculateShortestSubArray(int[] nums, Map<Integer, Integer> count, Map<Integer, Integer> first) {
        int res = 0;
        int degree = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}