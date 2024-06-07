package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/optimal-partition-of-string/description/
// 2405. Optimal Partition of String
class Solution {
    public int partitionString(String s) {
        Set<Character> unique = new HashSet<>();
        int partitions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (unique.contains(ch)) {
                unique.clear();
                partitions++;
            }
            unique.add(ch);
        }
        return partitions + 1;
    }
}