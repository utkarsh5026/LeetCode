package dynamic_programming.hard;

// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/
// 1526. Minimum Number of Increments on Subarrays to Form a Target Array
class Solution {
    public int minNumberOperations(int[] target) {
        int operations = target[0]; // Initial operation needed to reach the first element value
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1]; // Only add positive differences
            }
        }
        return operations;
    }
}
