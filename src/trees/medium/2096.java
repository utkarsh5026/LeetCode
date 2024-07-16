package trees.medium;

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

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
// 2096. Step-By-Step Directions From a Binary Tree Node to Another
class Solution {

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char PARENT = 'U';

    class Connecttion {
        int value;
        char relation;

        public Connecttion(int value, char relation) {
            this.value = value;
            this.relation = relation;
        }
    }

    class Node {
        int node;
        String path;

        public Node(int node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, List<Connecttion>> graph = new HashMap<>();
        treeToGraph(-1, root, graph);

        Set<Integer> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startValue, ""));

        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                Node curr = queue.pollFirst();
                visited.add(curr.node);

                if (curr.node == destValue)
                    return curr.path;

                List<Connecttion> connections = graph.getOrDefault(curr.node, new ArrayList<>());

                for (Connecttion conn : connections) {
                    if (!visited.contains(conn.value))
                        queue.add(new Node(conn.value, curr.path + conn.relation));
                }
            }
        }

        return "";
    }

    TreeNode treeToGraph(int parent, TreeNode root, Map<Integer, List<Connecttion>> graph) {
        if (root == null)
            return null;

        graph.putIfAbsent(root.val, new ArrayList<>());
        if (parent != -1) {
            graph.get(root.val).add(new Connecttion(parent, PARENT));
        }

        TreeNode left = treeToGraph(root.val, root.left, graph);
        TreeNode right = treeToGraph(root.val, root.right, graph);

        if (left != null)
            graph.get(root.val).add(new Connecttion(left.val, LEFT));

        if (right != null)
            graph.get(root.val).add(new Connecttion(right.val, RIGHT));

        return root;
    }

}