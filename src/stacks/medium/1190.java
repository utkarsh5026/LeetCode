package stacks.medium;

import java.util.*;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
// 1190. Reverse Substrings Between Each Pair of Parentheses
class Solution {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());

        for (char ch : s.toCharArray()) {
            if (ch == LEFT_BRACKET) {
                stack.push(new StringBuilder());
            } else if (ch == RIGHT_BRACKET) {
                StringBuilder reversed = stack.pop().reverse();
                stack.peek().append(reversed);
            } else {
                stack.peek().append(ch);
            }
        }

        return stack.pop().toString();
    }
}