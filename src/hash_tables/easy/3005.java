package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/count-elements-with-maximum-frequency/description/
// 3005. Count Elements With Maximum Frequency
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int count : countMap.values()) {
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }

        // Sum up the frequencies of elements with the maximum frequency
        int totalFrequency = 0;
        for (int count : countMap.values()) {
            if (count == maxFrequency) {
                totalFrequency += count;
            }
        }

        return totalFrequency;
    }
}
