package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/check-distances-between-same-letters/description/
// 2399. Check Distances Between Same Letters
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i;
            } else {
                int expectedDistance = distance[index];
                int actualDistance = i - firstOccurrence[index] - 1;

                if (actualDistance != expectedDistance) {
                    return false;
                }
            }
        }

        return true;
    }
}
