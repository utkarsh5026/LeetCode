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

// https://leetcode.com/problems/binary-tree-tilt/description/
// 563. Binary Tree Tilt
class Solution {
    public int findTilt(TreeNode root) {
        tilt(root);
        return calcTotalTilt(root);
    }

    private int tilt(TreeNode root) {
        if (root == null)
            return 0;

        int currentVal = root.val;

        int left = tilt(root.left);
        int right = tilt(root.right);
        root.val = Math.abs(right - left);
        return currentVal + left + right;
    }

    private int calcTotalTilt(TreeNode root) {
        if (root == null)
            return 0;
        int left = calcTotalTilt(root.left);
        int right = calcTotalTilt(root.right);
        return left + right + root.val;
    }
}