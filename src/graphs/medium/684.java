package graphs.medium;

// https://leetcode.com/problems/redundant-connection/description
// 684. Redundant Connection
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Initialize the graph using Union-Find
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // Helper function to find the root of a node

        // Iterate through each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent)) {
                return edge; // Return the edge that forms a cycle
            }
        }

        return new int[0];
    }

    // Helper function to union two nodes
    boolean union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) {
            return false; // Cycle detected
        }
        parent[rootX] = rootY; // Union
        return true;
    }

    int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // Path compression
        }
        return parent[x];
    }

}
