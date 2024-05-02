package stacks.medium;

import java.util.*;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// 150. Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> equation = new ArrayDeque<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        int start = 0;

        while (start < tokens.length) {
            String token = tokens[start];
            boolean isNumber = !operators.contains(token);
            start++;

            if (isNumber) {
                equation.add(token);
                continue;
            }
            int b = Integer.parseInt(equation.pollLast());
            int a = Integer.parseInt(equation.pollLast());

            int result = calculate(a, b, token);
            equation.add(String.valueOf(result));
        }
        return Integer.parseInt(equation.pop());
    }

    private int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            default:
                return a / b;
        }
    }
}