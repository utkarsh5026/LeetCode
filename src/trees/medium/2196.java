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

// https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
// 2196. Create Binary Tree From Descriptions
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> connections = new HashMap<>();

        Set<Integer> childrenNodes = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            connections.computeIfAbsent(parent, children -> new int[] { -1, -1 });
            connections.computeIfAbsent(child, children -> new int[] { -1, -1 });
            int idx = isLeft ? 0 : 1;
            connections.get(parent)[idx] = child;
            childrenNodes.add(child);
        }

        int root = -1;
        for (Map.Entry<Integer, int[]> connection : connections.entrySet()) {
            int parent = connection.getKey();
            if (!childrenNodes.contains(parent)) {
                root = parent;
                break;
            }
        }

        return buildTree(root, connections);
    }

    TreeNode buildTree(int val, Map<Integer, int[]> connections) {
        if (val == -1)
            return null;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(connections.get(val)[0], connections);
        root.right = buildTree(connections.get(val)[1], connections);

        return root;
    }
}
