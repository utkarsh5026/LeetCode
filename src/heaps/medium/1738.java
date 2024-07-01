package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/description/
// 1738. Find Kth Largest XOR Coordinate Value
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] xored = new int[rows][cols];

        // Initialize the first cell
        xored[0][0] = matrix[0][0];

        // Initialize the first row
        for (int j = 1; j < cols; j++) {
            xored[0][j] = xored[0][j - 1] ^ matrix[0][j];
        }

        // Initialize the first column
        for (int i = 1; i < rows; i++) {
            xored[i][0] = xored[i - 1][0] ^ matrix[i][0];
        }

        // Compute the XOR for the rest of the cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                xored[i][j] = xored[i - 1][j] ^ xored[i][j - 1] ^ xored[i - 1][j - 1] ^ matrix[i][j];
            }
        }

        // Using a min heap to find the kth largest element
        return getKthLargest(xored, k);
    }

    int getKthLargest(int[][] xored, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < xored.length; i++) {
            for (int j = 0; j < xored[0].length; j++) {
                minHeap.add(xored[i][j]);
                if (minHeap.size() > limit) {
                    minHeap.poll();
                }
            }
        }

        return minHeap.peek();
    }
}
