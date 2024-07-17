package stacks.easy;

import java.util.*;

// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
// 1614. Maximum Nesting Depth of the Parentheses
class Solution {
    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public int maxDepth(String s) {
        int maximum = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != LEFT && ch != RIGHT)
                continue;

            if (ch == LEFT)
                stack.add(ch);
            else if (ch == RIGHT && !stack.isEmpty())
                stack.pollLast();

            maximum = Math.max(maximum, stack.size());
        }
        return maximum;
    }
}