package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
// 378. Kth Smallest Element in a Sorted Matrix
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Initialize the PriorityQueue as a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll(); // Remove the largest element to maintain size k
                }
            }
        }

        return maxHeap.peek(); // The root of the max-heap is the kth smallest element
    }
}
