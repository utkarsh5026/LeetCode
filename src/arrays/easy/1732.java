package arrays.easy;

// https://leetcode.com/problems/find-the-highest-altitude/description/
// 1732. Find the Highest Altitude
class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = Integer.MIN_VALUE;
        int currHeight = 0;

        for (int height : gain) {
            currHeight += height;
            maxHeight = Math.max(currHeight, maxHeight);
        }

        return maxHeight > 0 ? maxHeight : 0;
    }
}
