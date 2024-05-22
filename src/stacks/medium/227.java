package stacks.medium;

import java.util.*;

// https://leetcode.com/problems/basic-calculator-ii/description/
// 227. Basic Calculator II
class Solution {
    public int calculate(String s) {
        String spaceReplaced = s.replaceAll("\\s+", "");
        String posfix = infixToPostfix(spaceReplaced);

        return evaluatePostfix(posfix);
    }

    String infixToPostfix(String expression) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        StringBuilder postfix = new StringBuilder();
        Deque<Character> operators = new ArrayDeque<>();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    postfix.append(expression.charAt(i));
                    i++;
                }
                postfix.append(' '); // Add space to separate operands
                i--; // Step back to handle the non-digit character in the next iteration
            } else {
                while (!operators.isEmpty() && precedence.get(operators.peekLast()) >= precedence.get(c)) {
                    postfix.append(operators.pollLast());
                    postfix.append(' ');
                }
                operators.addLast(c);
            }
            i++;
        }

        while (!operators.isEmpty()) {
            postfix.append(operators.pollLast());
            postfix.append(' ');
        }

        return postfix.toString().trim();
    }

    int evaluatePostfix(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // If the token is a number
                stack.push(Integer.parseInt(token));
            } else { // The token is an operator
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }
}