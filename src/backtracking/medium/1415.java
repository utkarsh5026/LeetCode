package backtracking.medium;

import java.util.*;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
// 1415. The k-th Lexicographical String of All Happy Strings of Length n
class Solution {
    public String getHappyString(int n, int k) {
        List<String> happy = new ArrayList<>();
        char[] set = { 'a', 'b', 'c' };
        backtrack(n, "", set, happy);
        Collections.sort(happy);

        return k <= happy.size() ? happy.get(k - 1) : "";
    }

    void backtrack(int n, String psf, char[] set, List<String> happy) {
        if (psf.length() == n) {
            happy.add(psf);
            return;
        }

        for (char c : set) {
            if (psf.isEmpty() || psf.charAt(psf.length() - 1) != c) {
                backtrack(n, psf + c, set, happy);
            }
        }
    }
}