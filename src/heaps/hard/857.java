package heaps.hard;

import java.util.*;

// 857. Minimum Cost to Hire K Workers
// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/
class Solution {
    static class Worker {
        double ratio;
        double quality;

        Worker(double wage, double quality) {
            this.ratio = wage / quality;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }

        Arrays.sort(workers, (w1, w2) -> Double.compare(w1.ratio, w2.ratio));

        return calculateMinCost(workers, k);
    }

    double calculateMinCost(Worker[] workers, int k) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (Worker worker : workers) {
            qualitySum += worker.quality;
            maxHeap.add(worker.quality);

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll(); // Remove the worker with the highest quality
            }

            if (maxHeap.size() == k) {
                double cost = qualitySum * worker.ratio; // Current worker's ratio as the cost factor
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

}