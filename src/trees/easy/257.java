package trees.easy;

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

// https://leetcode.com/problems/binary-tree-paths/description/
// 257. Binary Tree Paths
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null)
            return paths;
        createPaths(root, String.valueOf(root.val), paths);
        return paths;
    }

    private void createPaths(TreeNode root, String nodesSoFar, List<String> paths) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            paths.add(nodesSoFar);
            return;
        }

        if (root.left != null)
            createPaths(root.left, nodesSoFar + "->" + root.left.val, paths);

        if (root.right != null)
            createPaths(root.right, nodesSoFar + "->" + root.right.val, paths);
    }
}