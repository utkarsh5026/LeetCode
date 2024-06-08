package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
// 1636. Sort Array by Increasing Frequency
class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> groups = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            groups.computeIfAbsent(frequency, k -> new ArrayList<>()).add(num);
        }

        for (List<Integer> group : groups.values()) {
            group.sort(Comparator.reverseOrder());
        }

        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int frequency = entry.getKey();
            List<Integer> group = entry.getValue();
            for (int num : group) {
                for (int i = 0; i < frequency; i++) {
                    nums[index++] = num;
                }
            }
        }

        return nums;
    }
}
