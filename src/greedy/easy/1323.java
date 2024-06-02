package greedy.easy;

// https://leetcode.com/problems/maximum-69-number/description/
// 1323. Maximum 69 Number
class Solution {
    public int maximum69Number(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        for (int i = 0; i < digits.length; i++) {
            int digit = Integer.parseInt(String.valueOf(digits[i]));
            if (digit == 9)
                continue;

            digits[i] = '9';
            break;
        }
        return Integer.parseInt(new String(digits));
    }
}