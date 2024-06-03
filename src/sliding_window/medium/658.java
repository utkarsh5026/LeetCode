package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/find-k-closest-elements/description/
// 658. Find K Closest Elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> closest = new ArrayList<>();
        int idx = findElement(arr, x);

        int left = idx - 1;
        int right = idx + 1;

        if (idx >= 0 && idx < arr.length)
            closest.add(arr[idx]);

        while (closest.size() < k) {
            if (left < 0) {
                closest.add(arr[right++]);
            } else if (right >= arr.length) {
                closest.add(arr[left--]);
            } else {
                int fromLeft = arr[left];
                int fromRight = arr[right];

                if (Math.abs(x - fromLeft) <= Math.abs(x - fromRight)) {
                    closest.add(fromLeft);
                    left--;
                } else {
                    closest.add(fromRight);
                    right++;
                }
            }
        }

        Collections.sort(closest);
        return closest;
    }

    int findElement(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left])
            return -1;
        if (target > arr[right])
            return arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int element = arr[mid];

            if (element == target)
                return mid;

            if (target > element)
                left = mid + 1;
            else
                right = mid;
        }

        return (left == 0 || Math.abs(arr[left - 1] - target) <= Math.abs(arr[left] - target)) ? left - 1 : left;
    }
}
