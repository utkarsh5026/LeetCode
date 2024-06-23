package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
// 893. Groups of Special-Equivalent Strings
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> uniqueGroups = new HashSet<>();

        for (String word : words) {
            int n = word.length();
            char[] evenChars = new char[(n + 1) / 2];
            char[] oddChars = new char[n / 2];

            // Separate even and odd indexed characters
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    evenChars[i / 2] = word.charAt(i);
                } else {
                    oddChars[i / 2] = word.charAt(i);
                }
            }

            // Sort the characters
            Arrays.sort(evenChars);
            Arrays.sort(oddChars);

            // Create the normalized form
            String normalized = new String(evenChars) + new String(oddChars);
            uniqueGroups.add(normalized);
        }

        return uniqueGroups.size();
    }
}