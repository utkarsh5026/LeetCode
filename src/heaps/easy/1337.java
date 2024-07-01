package heaps.easy;

import java.util.PriorityQueue;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
// 1337. The K Weakest Rows in a Matrix
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] oneCnt = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int num : mat[i]) {
                if (num == 0)
                    break;
                else
                    oneCnt[i]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (oneCnt[a] == oneCnt[b])
                return a - b;
            return oneCnt[a] - oneCnt[b];
        });

        for (int i = 0; i < mat.length; i++) {
            pq.add(i);
        }

        int[] weakest = new int[k];
        for (int i = 0; i < k; i++) {
            weakest[i] = pq.poll();
        }

        return weakest;
    }
}