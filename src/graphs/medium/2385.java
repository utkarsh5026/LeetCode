package graphs.medium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
// 2385. Amount of Time for Binary Tree to Be Infecteds
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        makeGraph(root, graph, -1);
        return bfs(start, graph);
    }

    private void makeGraph(TreeNode root, Map<Integer, List<Integer>> graph, int parent) {
        if (root == null)
            return;

        int curr = root.val;
        graph.put(curr, new ArrayList<>());

        if (parent != -1) {
            graph.get(curr).add(parent);
            graph.get(parent).add(curr);
        }

        makeGraph(root.left, graph, curr);
        makeGraph(root.right, graph, curr);
    }

    int bfs(int start, Map<Integer, List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        int minutes = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int nodes = queue.size();

            for (int i = 0; i < nodes; i++) {
                int node = queue.pollFirst();
                visited.add(node);
                if (!graph.containsKey(node))
                    continue;
                for (int child : graph.get(node)) {
                    if (!visited.contains(child))
                        queue.add(child);
                }
            }

            minutes++;
        }

        return minutes;
    }
}
