package heaps.medium;

import java.util.*;

// https:// leetcode.com/problems/maximum-average-pass-ratio/description/
// 1792. Maximum Average Pass Ratio
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(profitRatio(b[0], b[1]), profitRatio(a[0], a[1])));

        for (int[] c : classes) {
            pq.offer(new double[] { c[0], c[1] });
        }

        while (extraStudents > 0) {
            double[] cur = pq.poll();
            cur[0]++;
            cur[1]++;
            pq.offer(cur);
            extraStudents--;
        }

        double totalRatio = 0;
        int n = classes.length;

        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            totalRatio += c[0] / c[1];
        }

        return totalRatio / n;
    }

    private double profitRatio(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}