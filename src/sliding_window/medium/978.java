package sliding_window.medium;

// https://leetcode.com/problems/longest-turbulent-subarray/description/
// 978. Longest Turbulent Subarray
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }

        int maxSize = 1;
        int left = 0;

        for (int i = 1; i < arr.length; i++) {
            int prevCompare = Integer.compare(arr[i - 1], arr[i]);
            if (prevCompare == 0) {
                left = i;
            } else if (i < arr.length - 1) {
                int nextCompare = Integer.compare(arr[i], arr[i + 1]);
                if (nextCompare * prevCompare != -1) {
                    maxSize = Math.max(maxSize, i - left + 1);
                    left = i;
                }
            }

        }

        maxSize = Math.max(maxSize, arr.length - left);
        return maxSize;
    }
}
