package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/
// 3194. Minimum Average of Smallest and Largest Elementss
class Solution {
    public double minimumAverage(int[] nums) {
        List<Double> averages = new ArrayList<>();
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int a = nums[left++];
            int b = nums[right--];

            averages.add((double) (a + b) / 2);
        }

        return Collections.min(averages);
    }
}