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

// https://leetcode.com/problems/range-sum-of-bst/description/
// 938. Range Sum of BST
class Solution {
    private int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        solve(root, low, high);
        return rangeSum;
    }

    private void solve(TreeNode root, int low, int high) {
        if (root == null)
            return;

        if (root.val >= low && root.val <= high)
            rangeSum += root.val;

        if (root.val > low)
            solve(root.left, low, high);
        if (root.val < high)
            solve(root.right, low, high);

    }

}