package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
// 921. Minimum Add to Make Parentheses Valid
class Solution {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int steps = 0;

        for (char ch : s.toCharArray()) {
            if (ch == LEFT)
                stack.addLast(ch);

            else if (ch == RIGHT) {
                if (!stack.isEmpty() && stack.peekLast() == LEFT)
                    stack.pollLast();

                else
                    steps++;
            }
        }
        return steps + stack.size();
    }
}