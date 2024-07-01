package heaps.hard;

import java.util.*;

// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/description/
// 2642. Design Graph With Shortest Path Calculator
class Graph {
    private final List<List<int[]>> adjList; // adjacency list to store [to, weight]
    private final int n; // number of nodes

    public Graph(int n, int[][] edges) {
        this.n = n;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge); // add initial edges
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        adjList.get(from).add(new int[] { to, cost });
    }

    public int shortestPath(int node1, int node2) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node1] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[] { node1, 0 }); // [node, distance to node]

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentNode == node2) {
                return currentDist;
            }

            if (currentDist > distances[currentNode]) {
                continue; // Skip if we found a shorter way to the current node
            }

            for (int[] neighbor : adjList.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    minHeap.offer(new int[] { nextNode, newDist });
                }
            }
        }

        return distances[node2] == Integer.MAX_VALUE ? -1 : distances[node2];
    }
}
