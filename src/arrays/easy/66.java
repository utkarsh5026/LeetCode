package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/plus-one/description/
// 66. Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> increment = new ArrayList<>();
        int end = digits.length - 1;
        int carry = 1;

        while (end >= 0 || carry > 0) {
            int sum = 0;
            if (end >= 0)
                sum += digits[end];

            sum += carry;
            increment.add(sum % 10);
            carry = sum / 10;
            end--;
        }

        int[] arr = new int[increment.size()];
        Collections.reverse(increment);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = increment.get(i);
        }

        return arr;
    }
}