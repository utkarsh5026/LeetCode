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

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
// 111. Minimum Depth of Binary Tree
class Solution {
    public int minDepth(TreeNode root) {
        int result = search(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int search(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        if (root.left == null && root.right == null)
            return 1;

        int left = search(root.left);
        int right = search(root.right);
        return 1 + Math.min(left, right);
    }

}