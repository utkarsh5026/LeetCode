package graphs.medium;

import java.util.*;


// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/
//  1625. Lexicographically Smallest String After Applying Operations
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        dfs(s, a, b, visited);
        return Collections.min(visited);
    }

    void dfs(String s, int increment, int rotate, Set<String> visited) {
        if (visited.contains(s))
            return;

        visited.add(s);

        dfs(rotate(s, rotate), increment, rotate, visited);
        dfs(incrementAtOddPos(s, increment), increment, rotate, visited);
    }

    String rotate(String s, int k) {
        int size = s.length();
        k = k % size;

        if (k == 0)
            return s;

        String part1 = s.substring(size - k);
        String part2 = s.substring(0, size - k);
        return part1 + part2;
    }

    String incrementAtOddPos(String s, int k) {
        StringBuilder incremented = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i % 2 == 1) {
                int charInt = ch - '0';
                charInt = (charInt + k) % 10;
                ch = (char) (charInt + '0');
            }
            incremented.append(ch);
        }
        return incremented.toString();
    }
}