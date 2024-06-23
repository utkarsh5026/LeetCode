package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/
// 3083. Existence of a Substring in a String and Its Reverse
class Solution {
    public boolean isSubstringPresent(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        Set<String> normal = makeSubStringsSet(s);
        Set<String> reverset = makeSubStringsSet(reversed);

        for (String sub : normal) {
            if (reverset.contains(sub))
                return true;
        }

        return false;
    }

    Set<String> makeSubStringsSet(String s) {
        Set<String> subset = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            subset.add(sub);
        }
        return subset;
    }

}