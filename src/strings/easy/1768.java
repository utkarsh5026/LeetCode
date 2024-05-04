// https://leetcode.com/problems/merge-strings-alternately/description/
// 1768. Merge Strings Alternately
class Solution {
    public String meregeAlternatively(String word1, String word2) {
        int word1Idx = 0;
        int word2Idx = 0;

        StringBuilder merged = new StringBuilder();
        while (word1Idx < word1.length() || word2Idx < word2.length()) {
            if (word1Idx < word1.length())
                merged.append(word1.charAt(word1Idx));

            if (word2Idx < word2.length())
                merged.append(word2.charAt(word2Idx));

            word1Idx++;
            word2Idx++;
        }

        return merged.toString();
    }
}