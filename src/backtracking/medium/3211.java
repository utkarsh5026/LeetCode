package backtracking.medium.*;

import java.util.*;

// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/
// 3211. Generate Binary Strings Without Adjacent Zeros
class Solution {
    public List<String> validStrings(int n) {
                List<String> result = new ArrayList<>();
        if (n > 0) {
            generateStrings("1", n, result);
            generateStrings("0", n, result);
        }
        return result;
    }

    private static void generateStrings(String s, int n, List<String> result) {
        if (s.length() == n) {
            result.add(s);
            return;
        }

        if (s.charAt(s.length() - 1) == '1') {
            generateStrings(s + '0', n, result);
            generateStrings(s + '1', n, result);
        } else {
            generateStrings(s + '1', n, result);
        }
    }
}