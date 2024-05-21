package trees.hard;

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

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// 124. Binary Tree Maximum Path Sum
class Solution {
    int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    int solve(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int left = solve(root.left);
        int right = solve(root.right);

        int maxSumSide = Math.max(left, right);
        int bestSum = Math.max(root.val, root.val + maxSumSide);

        maxSum = Math.max(maxSum, Math.max(maxSumSide, root.val + left + right));
        return bestSum;
    }
}
