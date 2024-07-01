package heaps.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
// 1464. Maximum Product of Two Elements in an Arrays
class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        return (pq.poll() - 1) * (pq.poll() - 1);
    }
}
