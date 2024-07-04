package heaps.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/
// 2530. Maximal Score After Applying K Operations
class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            sum += max;
            maxHeap.add((int) Math.ceil((double) max / (double) 3));
        }
        return sum;
    }
}