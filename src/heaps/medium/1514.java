package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/path-with-maximum-probability/description/
//  1514. Path with Maximum Probability
class Solution {

    static class Edge {
        int node;
        double prob;

        public Edge(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Edge(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Edge(edge[0], succProb[i]));
        }

        // Max heap to maximize the probabilities
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        pq.add(new Edge(start, 1.0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            double currentProb = current.prob;

            if (currentNode == end) {
                return currentProb;
            }

            // Process each adjacent node
            for (Edge next : graph.get(currentNode)) {
                double newProb = currentProb * next.prob;
                if (newProb > maxProb[next.node]) {
                    maxProb[next.node] = newProb;
                    pq.add(new Edge(next.node, newProb));
                }
            }
        }

        return 0.0; // No path found
    }
}