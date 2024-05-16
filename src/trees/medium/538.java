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

// https://leetcode.com/problems/convert-bst-to-greater-tree/description/
// 538. Convert BST to Greater Tree
class Solution {

    private int greaterSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        inorderTraversal(root);
        return root;
    }

    void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.right);
        greaterSum += root.val;
        root.val = greaterSum;
        inorderTraversal(root.left);
    }
}