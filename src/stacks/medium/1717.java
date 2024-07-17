package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?
// 1717. Maximum Score From Removing Substrings
class Solution {
    private static final String AB = "ab";
    private static final String BA = "ba";

    public int maximumGain(String s, int x, int y) {
        String maxString = x > y ? AB : BA;
        int maxScore = x > y ? x : y;
        int minScore = maxScore == x ? y : x;
        Deque<Character> stack = new ArrayDeque<>();

        int score = 0;
        for (char ch : s.toCharArray()) {
            if (ch != 'a' || ch != 'b')
                continue;

            if (stack.isEmpty() || notInDomain(stack.peekLast(), ch)) {
                stack.add(ch);
                continue;
            }

            String comp = str(stack.peekLast(), ch);
            if (maxString.equals(comp)) {
                score += maxScore;
                stack.pollLast();
            } else {
                stack.add(ch);
            }
        }

        while (stack.size() >= 2) {
            char last = stack.pollLast();
            char secLast = stack.pollLast();

            boolean isMax = str(last, secLast).equals(maxString);
            if (isMax)
                score += maxScore;
            else if (!isMax && !notInDomain(last, secLast))
                score += minScore;
            else
                stack.add(secLast);
        }

        return score;
    }

    boolean notInDomain(char stackTop, char curr) {
        return AB.equals(str(stackTop, curr)) || BA.equals(str(stackTop, curr));
    }

    String str(char a, char b) {
        return a + "" + b;
    }
}