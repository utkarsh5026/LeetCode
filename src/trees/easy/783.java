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

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
// 783. Minimum Distance Between BST Nodes
class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nodes.size(); i++) {
            minDiff = Math.min(minDiff, nodes.get(i) - nodes.get(i - 1));
        }
        return minDiff;
    }

    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
}
