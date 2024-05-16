package trees.medium;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// 429. N-ary Tree Level Order Traversal
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> level = new ArrayList<>();
        if (root != null)
            bfs(root, level);
        return level;
    }

    void bfs(Node root, List<List<Integer>> level) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> nodesAtLevel = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                Node node = queue.pollFirst();
                nodesAtLevel.add(node.val);

                for (Node child : node.children) {
                    if (child != null)
                        queue.add(child);
                }
            }
            level.add(nodesAtLevel);
        }
    }
}
