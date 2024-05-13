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

// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
// 671. Second Minimum Node In a Binary Tree
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return -1;

        int secondMin = solve(root, root.val);
        return secondMin;
    }

    int solve(TreeNode root, int parentVal) {
        if (root == null)
            return -1;

        if (root.val > parentVal)
            return root.val;

        int left = solve(root.left, root.val);
        int right = solve(root.right, parentVal);

        if (left < 0 && right < 0)
            return left;
        if (left < 0)
            return right;
        else if (right < 0)
            return left;

        return Math.min(left, right);
    }
}
