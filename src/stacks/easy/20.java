package stacks.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-parentheses/description/
// 20. Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        Deque<String> brackets = new ArrayDeque<>();
        Set<String> opening = new HashSet<>(Arrays.asList("(", "[", "{"));

        for (int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));

            if (opening.contains(curr)) {
                brackets.add(curr);
                continue;
            }
            if (brackets.isEmpty())
                return false;
            if (!isMatchingBracket(curr, brackets.peekLast()))
                return false;
            brackets.pollLast();
        }
        return brackets.isEmpty();
    }

    private boolean isMatchingBracket(String end, String begin) {
        if (end.equals(")"))
            return begin.equals("(");
        if (end.equals("}"))
            return begin.equals("{");
        return begin.equals("[");
    }
}