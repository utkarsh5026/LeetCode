package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/maximum-product-after-k-increments/description/
//  2233. Maximum Product After K Increments
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer((long) num);
        }

        for (int i = 0; i < k; i++) {
            long smallest = pq.poll();
            pq.offer(smallest + 1);
        }

        long product = 1;
        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % mod;
        }

        return (int) product;
    }
}