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

// https://leetcode.com/problems/sum-of-left-leaves/description/
// 404. Sum of Left Leaves
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return countSumOfLeftLeaves(root.left, true) + countSumOfLeftLeaves(root.right, false);
    }

    private int countSumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;

        if (isLeft && root.left == null && root.right == null)
            return root.val;

        int left = countSumOfLeftLeaves(root.left, true);
        int right = countSumOfLeftLeaves(root.right, false);

        return left + right;
    }
}