package dynamic_programming.medium;

// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/
// 1638. Count Substrings That Differ by One Character
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += countMismatchSubstrings(s, t, i, j);
            }
        }

        return count;
    }

    private int countMismatchSubstrings(String s, String t, int i, int j) {
        int m = s.length();
        int n = t.length();
        int count = 0;
        int mismatch = 0;

        for (int k = 0; i + k < m && j + k < n; k++) {
            if (s.charAt(i + k) != t.charAt(j + k)) {
                mismatch++;
            }
            if (mismatch == 1) {
                count++;
            } else if (mismatch > 1) {
                break;
            }
        }

        return count;
    }
}