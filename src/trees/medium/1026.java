package trees.medium;

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

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
// 1026. Maximum Difference Between Node and Ancestor
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    int dfs(TreeNode root, int min, int max) {
        if (root == null)
            return Math.abs(max - min);

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        int leftDiff = dfs(root.left, min, max);
        int rightDiff = dfs(root.right, min, max);

        return Math.max(leftDiff, rightDiff);
    }
}
