package greedy.easy;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
// 2160. Minimum Sum of Four Digit Number After Splitting Digits
class Solution {
    public int minimumSum(int num) {
        int[] dig = new int[4]; // For each digit
        int cur = 0;
        while (num > 0) // Getting each digit
        {
            dig[cur++] = num % 10;
            num /= 10;
        }
        Arrays.sort(dig);
        int num1 = dig[0] * 10 + dig[2];
        int num2 = dig[1] * 10 + dig[3];
        return num1 + num2;
    }
}