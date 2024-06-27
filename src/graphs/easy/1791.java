package graphs.easy;

// https://leetcode.com/problems/find-center-of-star-graph/description/
// 1791. Find Center of Star Graph
class Solution {
    public int findCenter(int[][] edges) {
        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];
        int node4 = edges[1][1];

        // Check which node from the first edge matches with any node in the second edge
        if (node1 == node3 || node1 == node4) {
            return node1;
        } else {
            return node2;
        }
    }
}