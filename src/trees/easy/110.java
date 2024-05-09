package trees.easy;

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

// https://leetcode.com/problems/balanced-binary-tree/description/
// 110. Balanced Binary Tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(rightHeight - leftHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}