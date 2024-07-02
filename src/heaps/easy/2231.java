package heaps.easy;

import java.util.*;

// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/
// 2231. Largest Number After Digit Swaps by Parity
class Solution {
    public int largestInteger(int num) {
        String numStr = Integer.toString(num);
        List<Integer> oddDigits = new ArrayList<>();
        List<Integer> evenDigits = new ArrayList<>();

        // Separate digits into odd and even based on their parity
        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                evenDigits.add(digit);
            } else {
                oddDigits.add(digit);
            }
        }

        Collections.sort(oddDigits, Collections.reverseOrder());
        Collections.sort(evenDigits, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        int oddIndex = 0;
        int evenIndex = 0;

        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                result.append(evenDigits.get(evenIndex++));
            } else {
                result.append(oddDigits.get(oddIndex++));
            }
        }

        return Integer.parseInt(result.toString());
    }
}