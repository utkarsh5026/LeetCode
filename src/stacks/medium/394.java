package stacks.medium;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/description/
// 394. Decode String
class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentResult = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                counts.push(k);
                resultStack.push(currentResult);
                currentResult = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = currentResult;
                currentResult = resultStack.pop();
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    currentResult.append(decodedString);
                }
            } else {
                currentResult.append(ch);
            }
        }

        return currentResult.toString();
    }
}
