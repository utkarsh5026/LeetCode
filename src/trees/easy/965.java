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

// https://leetcode.com/problems/univalued-binary-tree/description/
// 965. Univalued Binary Tree
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        return solve(root, root.val);
    }

    private boolean solve(TreeNode root, int rootVal) {
        if (root == null)
            return true;

        if (root.val != rootVal)
            return false;
        return solve(root.left, rootVal) && solve(root.right, rootVal);
    }
}