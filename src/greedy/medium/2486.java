package greedy.medium;

// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
// 2486. Append Characters to String to Make Subsequence
class Solution {
    public int appendCharacters(String s, String t) {
        int si = 0;
        int ti = 0;

        while (si < s.length() && ti < t.length()) {
            char tChar = t.charAt(ti);
            char sChar = s.charAt(si);

            if (sChar == tChar) {
                si++;
                ti++;
            } else {
                si++;
            }
        }

        return t.length() - ti;
    }
}
