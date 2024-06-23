package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/
// 2283. Check if Number Has Equal Digit Count and Digit Value
class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> digitCnt = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            digitCnt.put(digit, digitCnt.getOrDefault(digit, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++) {
            int cnt = num.charAt(i) - '0';
            if (digitCnt.getOrDefault(i, 0) != cnt)
                return false;
        }
        return true;
    }
}