package heaps.easy;

import java.util.*;

// https:// leetcode.com/problems/kth-largest-element-in-a-stream/description/
// 703. Kth Largest Element in a Stream
class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }

}
