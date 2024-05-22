package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description/
// 1657. Determine if Two Strings Are Close
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        boolean[] exist1 = new boolean[26];
        boolean[] exist2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
            exist1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
            exist2[c - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (exist1[i] != exist2[i]) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}
