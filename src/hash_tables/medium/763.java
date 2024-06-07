package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/partition-labels/description/
// 763. Partition Labels
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        // Step 1: Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
            }
        }

        return partitions;
    }
}
