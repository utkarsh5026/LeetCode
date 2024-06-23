package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/two-out-of-three/description/
// 2032. Two Out of Three
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : nums3) {
            set3.add(num);
        }

        // Use a map to count occurrences in sets
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : set1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : set2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : set3) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
