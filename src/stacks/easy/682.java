package stacks.easy;

import java.util.*;

// https://leetcode.com/problems/baseball-game/description/
// 682. Baseball Game
class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> ops = new HashSet<>(Arrays.asList("+", "D", "C"));

        for (String operation : operations) {
            if (ops.contains(operation))
                performOperation(stack, operation);
            else
                stack.add(Integer.parseInt(operation));
        }

        return getTotalScore(stack);
    }

    void performOperation(Deque<Integer> stack, String operation) {
        if (stack.isEmpty())
            return;

        if (operation.equals("C")) {
            stack.pollLast();
        } else if (operation.equals("D")) {
            int doubleScore = 2 * stack.peekLast();
            stack.add(doubleScore);
        } else {
            int last = stack.pollLast();
            int secondLast = stack.pollLast();
            int sum = last + secondLast;

            stack.add(secondLast);
            stack.add(last);
            stack.add(sum);
        }
    }

    int getTotalScore(Deque<Integer> stack) {
        int score = 0;
        while (!stack.isEmpty()) {
            score += stack.pollLast();
        }
        return score;
    }
}