package heaps.easy;

import java.util.*;

// https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
// 2500. Delete Greatest Value in Each Row
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            Arrays.sort(grid[i]);
        }

        int greatest = 0;
        for (int i = 0; i < cols; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < rows; j++) {
                pq.add(grid[j][i]);
            }
            greatest += pq.poll();
        }

        return greatest;
    }
}